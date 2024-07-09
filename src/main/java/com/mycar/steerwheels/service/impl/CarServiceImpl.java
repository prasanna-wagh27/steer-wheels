package com.mycar.steerwheels.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mycar.steerwheels.bo.Response;
import com.mycar.steerwheels.constants.ErrorConstants;
import com.mycar.steerwheels.entity.Car;
import com.mycar.steerwheels.exception.SteerWheelsException;
import com.mycar.steerwheels.repository.CarRepository;
import com.mycar.steerwheels.service.CarService;

@Service
public class CarServiceImpl implements CarService{
	
	@Autowired
	private CarRepository carRepo;

	@Override
	public void addCar(Car car) throws Exception {
		if(carRepo.existsByRegistrationNumber(car.getRegistrationNumber())) {
			throw new SteerWheelsException(ErrorConstants.INVALID.toString(), "This vehicle is already registered");
		}
		
		carRepo.save(car);
	}

	@Override
	public void updateCar(UUID carId, Car car) throws Exception {
		Car exiCar = carRepo.findById(carId)
				.orElseThrow( ()-> new SteerWheelsException(ErrorConstants.NOT_FOUND.toString(), "Car not found")) ;
		exiCar.setRegistrationNumber(car.getRegistrationNumber());
		exiCar.setDailyRent(car.getDailyRent());
		exiCar.setYear(car.getYear());
		exiCar.setAvailable(car.isAvailable());
		exiCar.setAvailableFrom(car.getAvailableFrom());
		exiCar.setAvailableTo(car.getAvailableTo());
		exiCar.setCarModel(car.getCarModel());
		exiCar.setCity(car.getCity());		
	}

	@Override
	public Response getAllCars(UUID cityId, Pageable pageable) throws Exception {
		Response response = new Response();
		Page<Car> page = carRepo.getAllCars(cityId, pageable);
		response.setData(page.getContent());
		response.setListCount(page.getTotalElements());
		return response;
	}

	@Override
	public void deleteCar(UUID carId) throws Exception {
		Car exiCar = carRepo.findById(carId)
				.orElseThrow( ()-> new SteerWheelsException(ErrorConstants.NOT_FOUND.toString(), "Car not found"));
		carRepo.delete(exiCar);
	}

}

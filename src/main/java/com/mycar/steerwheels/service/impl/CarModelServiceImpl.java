package com.mycar.steerwheels.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mycar.steerwheels.bo.Response;
import com.mycar.steerwheels.constants.ErrorConstants;
import com.mycar.steerwheels.entity.CarBrand;
import com.mycar.steerwheels.entity.CarModel;
import com.mycar.steerwheels.exception.SteerWheelsException;
import com.mycar.steerwheels.repository.CarBrandRepository;
import com.mycar.steerwheels.repository.CarModelRepository;
import com.mycar.steerwheels.service.CarModelService;

public class CarModelServiceImpl implements CarModelService{


	@Autowired
	private CarModelRepository carModelRepo;
	
	@Autowired
	private CarBrandRepository carBrandRepo;

	@Override
	public void addCarModel(CarModel carModel) throws Exception {

		CarBrand exiCarBrand = carBrandRepo.findById(carModel.getCarBrand().getCarBrandId()).orElseThrow(
				()-> new SteerWheelsException(ErrorConstants.NOT_FOUND.toString(), "Car Brand not found"));
		if (carModelRepo.existsByName(carModel.getName())) {
			throw new SteerWheelsException(ErrorConstants.INVALID.toString() , "Car Model already exists");
		}
		carModel.setCarBrand(exiCarBrand);
		carModelRepo.save(carModel);
		
	}

	@Override
	public void updateCarModel(UUID carModelId, CarModel carModel) throws Exception {
		CarBrand exiCarBrand = carBrandRepo.findById(carModel.getCarBrand().getCarBrandId()).orElseThrow(
				()-> new SteerWheelsException(ErrorConstants.NOT_FOUND.toString(), "Car Brand not found"));
		CarModel exiCarModel = carModelRepo.findById(carModelId).orElseThrow(
				()-> new SteerWheelsException(ErrorConstants.NOT_FOUND.toString(), "Car Model not found"));
		if(carModelRepo.existsByName(carModel.getName()) && (carModel.getName() != exiCarModel.getName())) {
			throw new SteerWheelsException(ErrorConstants.INVALID.toString() , "Car Model already exists");
		}
		exiCarModel.setName(carModel.getName());
		exiCarModel.setCarBrand(exiCarBrand);
		exiCarModel.setCarType(carModel.getCarType());
		exiCarModel.setSeatingCapacity(carModel.getSeatingCapacity());
		exiCarModel.setFuelType(carModel.getFuelType());
		carModelRepo.save(exiCarModel);
	}

	@Override
	public Response getCarModelById(UUID carModelId) throws Exception {
		Response response = new Response();
		CarModel exiCarModel = carModelRepo.findById(carModelId).orElseThrow(
				()-> new SteerWheelsException(ErrorConstants.NOT_FOUND.toString(), "Car Model not found"));
		response.setData(exiCarModel);
		return response;
	}
	
	@Override
	public Response getAllCarModels(Pageable pageable) throws Exception {
		Response response = new Response();
		Page<CarModel> page = carModelRepo.getAllCarModels(pageable);
		response.setData(page.getContent());
		response.setListCount(page.getTotalElements());
		return response;
	}

	
}

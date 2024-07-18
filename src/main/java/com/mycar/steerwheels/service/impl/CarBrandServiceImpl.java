package com.mycar.steerwheels.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mycar.steerwheels.bo.Response;
import com.mycar.steerwheels.constants.ErrorConstants;
import com.mycar.steerwheels.entity.CarBrand;
import com.mycar.steerwheels.exception.SteerWheelsException;
import com.mycar.steerwheels.repository.CarBrandRepository;
import com.mycar.steerwheels.service.CarBrandService;

@Service
public class CarBrandServiceImpl implements CarBrandService{
	
	@Autowired
	private CarBrandRepository carBrandRepo;

	@Override
	public void addCarBrand(CarBrand carBrand) throws Exception {
		if (carBrandRepo.existsByCarBrandName(carBrand.getCarBrandName())) {
			throw new SteerWheelsException(ErrorConstants.INVALID.toString() , "Car Brand already exists");
		}
		carBrandRepo.save(carBrand);
		
	}

	@Override
	public void updateCarBrand(UUID carBrandId, CarBrand carBrand) throws Exception {
		CarBrand exiCarBrand = carBrandRepo.findById(carBrandId).orElseThrow(
				()-> new SteerWheelsException(ErrorConstants.NOT_FOUND.toString(), "Car Brand not found"));
		if(carBrandRepo.existsByCarBrandName(carBrand.getCarBrandName()) && (carBrand.getCarBrandName() != exiCarBrand.getCarBrandName())) {
			throw new SteerWheelsException(ErrorConstants.INVALID.toString() , "Car Brand already exists");
		}
		exiCarBrand.setCarBrandName(carBrand.getCarBrandName());
		carBrandRepo.save(exiCarBrand);
	}

	@Override
	public Response getCarBrandById(UUID carBrandId) throws Exception {
		Response response = new Response();
		CarBrand exiCarBrand = carBrandRepo.findById(carBrandId).orElseThrow(
				()-> new SteerWheelsException(ErrorConstants.NOT_FOUND.toString(), "Car Brand not found"));
		response.setData(exiCarBrand);
		return response;
	}
	
	@Override
	public Response getAllCarBrands(Pageable pageable) throws Exception {
		Response response = new Response();
		Page<CarBrand> page = carBrandRepo.getAllCarBrands(pageable);
		response.setData(page.getContent());
		response.setListCount(page.getTotalElements());
		return response;
	}

}

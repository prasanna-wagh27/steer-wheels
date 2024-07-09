package com.mycar.steerwheels.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		CarBrand exiCarBrand = carBrandRepo.findByCarBrandName(carBrand.getCarBrandName());
		if (null != exiCarBrand) {
			throw new SteerWheelsException(ErrorConstants.INVALID.toString() , "Car Brand already exists");
		}
		carBrandRepo.save(carBrand);
		
	}

}

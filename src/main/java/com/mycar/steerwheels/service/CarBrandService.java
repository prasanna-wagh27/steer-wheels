package com.mycar.steerwheels.service;

import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.mycar.steerwheels.bo.Response;
import com.mycar.steerwheels.entity.CarBrand;

public interface CarBrandService {

	void addCarBrand(CarBrand carBrand) throws Exception;

	void updateCarBrand(UUID carBrandId, CarBrand carBrand) throws Exception;

	Response getCarBrandById(UUID carBrandId) throws Exception;

	Response getAllCarBrands(Pageable pageable) throws Exception;

}

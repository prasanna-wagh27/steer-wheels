package com.mycar.steerwheels.service;

import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.mycar.steerwheels.bo.Response;
import com.mycar.steerwheels.entity.CarModel;

public interface CarModelService {

	void addCarModel(CarModel carModel) throws Exception;

	void updateCarModel(UUID carModelId, CarModel carModel) throws Exception;

	Response getCarModelById(UUID carModelId) throws Exception;

	Response getAllCarModels(Pageable pageable) throws Exception;
	
	
}

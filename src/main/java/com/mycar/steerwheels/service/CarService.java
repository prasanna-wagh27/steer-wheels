package com.mycar.steerwheels.service;

import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.mycar.steerwheels.bo.Response;
import com.mycar.steerwheels.entity.Car;

public interface CarService {

	void addCar(Car car) throws Exception;

	void updateCar(UUID carId, Car car) throws Exception;

	Response getAllCars(UUID cityId, Pageable pageable) throws Exception;

	void deleteCar(UUID carId) throws Exception;

}

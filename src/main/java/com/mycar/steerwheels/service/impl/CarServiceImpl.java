package com.mycar.steerwheels.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.mycar.steerwheels.repository.CarRepository;
import com.mycar.steerwheels.service.CarService;

public class CarServiceImpl implements CarService{
	
	@Autowired
	private CarRepository carRepo;

}

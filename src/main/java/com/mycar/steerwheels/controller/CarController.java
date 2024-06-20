package com.mycar.steerwheels.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycar.steerwheels.service.CarService;

@RestController
@RequestMapping("${url.prefix}/car")
public class CarController {
	
	@Autowired
	private CarService carService;

}

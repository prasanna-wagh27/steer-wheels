package com.mycar.steerwheels.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycar.steerwheels.bo.Response;
import com.mycar.steerwheels.constants.ErrorConstants;
import com.mycar.steerwheels.entity.Car;
import com.mycar.steerwheels.service.CarService;

@RestController
@RequestMapping("${url.prefix}/car")
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Response> addCar(@RequestBody Car car) throws Exception{
		carService.addCar(car);
		Response response = new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("Car added successfully");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@PutMapping("/{carId}")
	public ResponseEntity<Response> updateCar(@PathVariable("carId") UUID carId, @RequestBody Car car) throws Exception{
		carService.updateCar(carId, car);
		Response response = new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("Car updated successfully");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
}

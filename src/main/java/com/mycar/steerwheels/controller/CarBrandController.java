package com.mycar.steerwheels.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycar.steerwheels.bo.Response;
import com.mycar.steerwheels.constants.ErrorConstants;
import com.mycar.steerwheels.entity.CarBrand;
import com.mycar.steerwheels.service.CarBrandService;

@RestController
@RequestMapping("${url.prefix}/car-brand")
public class CarBrandController {
	
	@Autowired
	private CarBrandService carBrandService;
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Response> addCarBrand(@RequestBody CarBrand carBrand) throws Exception{
		carBrandService.addCarBrand(carBrand);
		Response response = new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("Car Brand added successfully");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}

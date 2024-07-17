package com.mycar.steerwheels.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mycar.steerwheels.bo.Response;
import com.mycar.steerwheels.constants.ErrorConstants;
import com.mycar.steerwheels.entity.CarModel;
import com.mycar.steerwheels.service.CarModelService;

public class CarModelController {

	@Autowired
	private CarModelService carModelService;
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Response> addCarModel(@RequestBody CarModel carModel) throws Exception{
		carModelService.addCarModel(carModel);
		Response response = new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("Car Model added successfully");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@PutMapping("/{carModelId}")
	public ResponseEntity<Response> updateCarModel(@PathVariable("carBrandId") UUID carModelId, @RequestBody CarModel carModel) throws Exception{
		carModelService.updateCarModel(carModelId, carModel);
		Response response = new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("Car Model updated successfully");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	

	@CrossOrigin
	@PutMapping("/{carModelId}")
	public ResponseEntity<Response> getCarBrandById(@PathVariable("carModelId") UUID carModelId ) throws Exception{
		Response response = carModelService.getCarModelById(carModelId);
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("Car Model details");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping()
	public ResponseEntity<Response> getAllCarModels(@PageableDefault(page = 0, size = 10) Pageable pageable) throws Exception{
		Response response = carModelService.getAllCarModels(pageable);
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("Car Model List");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}

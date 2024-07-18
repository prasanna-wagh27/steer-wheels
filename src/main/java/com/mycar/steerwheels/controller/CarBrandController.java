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
	
	@CrossOrigin
	@PutMapping("/{carBrandId}")
	public ResponseEntity<Response> updateCarBrand(@PathVariable("carBrandId") UUID carBrandId ,@RequestBody CarBrand carBrand) throws Exception{
		carBrandService.updateCarBrand(carBrandId, carBrand);
		Response response = new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("Car Brand updated successfully");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	

	@CrossOrigin
	@GetMapping("/{carBrandId}")
	public ResponseEntity<Response> getCarBrandById(@PathVariable("carBrandId") UUID carBrandId ) throws Exception{
		Response response = carBrandService.getCarBrandById(carBrandId);
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("Car Brand details");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping()
	public ResponseEntity<Response> getAllCarBrands(@PageableDefault(page = 0, size = 10) Pageable pageable) throws Exception{
		Response response = carBrandService.getAllCarBrands(pageable);
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("Car Brand List");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	

}

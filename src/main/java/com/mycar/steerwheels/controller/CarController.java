package com.mycar.steerwheels.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<Response> getAllcars(@RequestParam(name = "cityId", required =  false) UUID cityId,
			@SortDefault(sort = "availableFrom", direction = Direction.DESC)
	@PageableDefault(page = 0, size = 10) Pageable pageable) throws Exception{
		Response response = carService.getAllCars(cityId ,pageable);
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("Car List");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@DeleteMapping("/{carId}")
	public ResponseEntity<Response> deleteCar(@PathVariable("carId") UUID carId) throws Exception{
		carService.deleteCar(carId);
		Response response = new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("Car deleted successfully");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
}

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycar.steerwheels.bo.Response;
import com.mycar.steerwheels.constants.ErrorConstants;
import com.mycar.steerwheels.entity.City;
import com.mycar.steerwheels.service.CityService;

@RestController("${url.prefix}/city")
public class CityController {
	
	@Autowired
	private CityService cityService;
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Response> addCity(@RequestBody City city) throws Exception{
		cityService.addCity(city);
		Response response = new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("City added successfully");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<Response> getAllCitiesByState(@RequestParam(name = "stateId", required = false) UUID stateId,
			@SortDefault(sort = "name", direction = Direction.ASC) 
	@PageableDefault(page = 0, size = 10) Pageable pageable) throws Exception{
		Response response = cityService.getAllCitiesByState(stateId, pageable);
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("All Cities List");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/active")
	public ResponseEntity<Response> getActiveCitiesByState(@RequestParam(name = "stateId", required = false) UUID stateId,
			@SortDefault(sort = "name", direction = Direction.ASC) 
	@PageableDefault(page = 0, size = 10) Pageable pageable) throws Exception{
		Response response = cityService.getActiveCities(stateId, pageable);
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("Active Cities List");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/{cityId}")
	public ResponseEntity<Response> getCityById(@PathVariable("cityId") UUID cityId) throws Exception{
		Response response =  new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("City Details");
		response.setData(cityService.getCityById(cityId));
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@PutMapping("/{cityId}")
	public ResponseEntity<Response> updateCity(@PathVariable("cityId") UUID cityId, @RequestBody City city) throws Exception{
		cityService.updateCity(cityId, city);
		Response response = new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("City updated successfully");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

}

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycar.steerwheels.bo.Response;
import com.mycar.steerwheels.constants.ErrorConstants;
import com.mycar.steerwheels.entity.Country;
import com.mycar.steerwheels.service.CountryService;

@RestController
@RequestMapping("${url.prefix}/country")
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Response> addCountry(@RequestBody Country country) throws Exception{
		countryService.addCountry(country);
		Response response = new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("Country added successfully");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<Response> getAllCountries(@SortDefault(sort = "countryName", direction = Direction.ASC) 
	@PageableDefault(page = 0, size = 10) Pageable pageable) throws Exception{
		Response response = countryService.getAllCountries(pageable);
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("All Countries List");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/active")
	public ResponseEntity<Response> getActiveCountries(@SortDefault(sort = "countryName", direction = Direction.ASC) 
	@PageableDefault(page = 0, size = 10) Pageable pageable) throws Exception{
		Response response = countryService.getActiveCountries(pageable);
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("Active Countries List");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/{countryId}")
	public ResponseEntity<Response> getCountryById(@PathVariable("countryId") UUID countryId) throws Exception{
		Response response =  new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("Country Details");
		response.setData(countryService.getCountryById(countryId));
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@PutMapping("/{countryId}")
	public ResponseEntity<Response> updateCountry(@PathVariable("countryId") UUID countryId, @RequestBody Country country) throws Exception{
		countryService.updateCountry(countryId ,country);
		Response response = new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("Country updated successfully");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	

}

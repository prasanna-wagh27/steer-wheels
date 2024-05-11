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

}

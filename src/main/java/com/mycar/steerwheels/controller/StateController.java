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

import com.mycar.steerwheels.bo.Response;
import com.mycar.steerwheels.constants.ErrorConstants;
import com.mycar.steerwheels.entity.State;
import com.mycar.steerwheels.service.StateService;

@RequestMapping("${url.prefix}/state")
public class StateController {
	
	@Autowired
	private StateService stateService;
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Response> addState(@RequestBody State state) throws Exception{
		stateService.addState(state);
		Response response = new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("State added successfully");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/{countryId}")
	public ResponseEntity<Response> getAllStates(@SortDefault(sort = "stateName", direction = Direction.ASC) 
	@PageableDefault(page = 0, size = 10) Pageable pageable, @PathVariable("countryId") UUID countryId) throws Exception{
		Response response = stateService.getAllStatesByCountry(countryId ,pageable);
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("All States List By Country");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/active/{countryId}")
	public ResponseEntity<Response> getActiveStatesByCountry(@SortDefault(sort = "stateName", direction = Direction.ASC) 
	@PageableDefault(page = 0, size = 10) Pageable pageable, @PathVariable("countryId") UUID countryId) throws Exception{
		Response response = stateService.getActiveStatesByCountry(countryId, pageable);
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("Active States List by country");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/{stateId")
	public ResponseEntity<Response> getStateById(@PathVariable("stateId") UUID stateId) throws Exception{
		Response response =  new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("State Details");
		response.setData(stateService.getStateById(stateId));
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@PutMapping("/{stateId}")
	public ResponseEntity<Response> updateState(@PathVariable("stateId") UUID stateId, @RequestBody State state) throws Exception{
		stateService.updateState(stateId, state);
		Response response = new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("State updated successfully");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

}

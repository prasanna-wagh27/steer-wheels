package com.mycar.steerwheels.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycar.steerwheels.bo.Response;
import com.mycar.steerwheels.bo.UserBO;
import com.mycar.steerwheels.constants.ErrorConstants;
import com.mycar.steerwheels.service.CustomerService;

@RequestMapping("${url.prefix}/passenger")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@CrossOrigin
	@PostMapping("/validate-mobile")
	public ResponseEntity<Response> validateMobileNumber(String mobileNumber) throws Exception{
		customerService.validateMobileNumber(mobileNumber);
		Response response = new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("Please verify your mobile number");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping("/verify-otp")
	public ResponseEntity<Response> verifyOtp(UserBO userBO) throws Exception{
		Response response = new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("OTP verified successfully");
		response.setData(customerService.verifyOtp(userBO));
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping("/register")
	public ResponseEntity<Response> registerCustomer(@RequestBody UserBO userBO) throws Exception{
		customerService.registerCustomer(userBO);
		Response response = new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("You have registered successfully");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	

}

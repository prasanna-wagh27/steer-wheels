package com.mycar.steerwheels.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycar.steerwheels.bo.Response;
import com.mycar.steerwheels.constants.ErrorConstants;
import com.mycar.steerwheels.entity.Booking;
import com.mycar.steerwheels.service.BookingService;

@RestController
@RequestMapping("${url.prefix}/booking")
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Response> bookCab(@RequestBody Booking booking) throws Exception{
		Response response = new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("Please make payment");
		response.setData(bookingService.bookCab(booking));
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

}

package com.mycar.steerwheels.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycar.steerwheels.bo.Response;
import com.mycar.steerwheels.constants.ErrorConstants;
import com.mycar.steerwheels.entity.BookingPayment;
import com.mycar.steerwheels.service.BookingPaymentService;

@RestController
@RequestMapping("${url.prefix}/booking-payment")
public class BookingPaymentController {
	
	@Autowired
	private BookingPaymentService bookingPaymentService;
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Response> doBookingPayment(BookingPayment bookingPayment) throws Exception{
		bookingPaymentService.doBookingPayment(bookingPayment);
		Response response = new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("Payment done successfully");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

}

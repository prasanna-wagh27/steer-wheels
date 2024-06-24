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
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<Response> bookCab(@RequestBody Booking booking) throws Exception {
		Response response = new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("Please make payment");
		response.setData(bookingService.bookCab(booking));
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@PutMapping("/cancel")
	public ResponseEntity<Response> cancelBooking(@RequestParam("bookingId") UUID bookingId) throws Exception {
		bookingService.cancelBooking(bookingId);
		Response response = new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("Booking cancelled successfully");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@PutMapping("/complete")
	public ResponseEntity<Response> completeRental(@RequestParam("bookingId") UUID bookingId) throws Exception {
		bookingService.completeRental(bookingId);
		Response response = new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("Rental completed successfully");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@GetMapping("/by-user/{userId}")
	public ResponseEntity<Response> getBookingsByUser(@PathVariable("userId") UUID userId,
			@SortDefault(sort = "pickupDate", direction = Direction.DESC) @PageableDefault(page = 0, size = 10) Pageable pageable)
			throws Exception {
		Response response = new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("Bookings List");
		response.setData(bookingService.getBookingsByUser(userId, pageable));
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<Response> getAllBookings(
			@SortDefault(sort = "pickupDate", direction = Direction.DESC) @PageableDefault(page = 0, size = 10) Pageable pageable)
			throws Exception {
		Response response = new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("All Bookings List");
		response.setData(bookingService.getAllBookings(pageable));
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/by-user/past/{userId}")
	public ResponseEntity<Response> getPastBookingsByUser(@PathVariable("userId") UUID userId,
			@SortDefault(sort = "pickupDate", direction = Direction.DESC) @PageableDefault(page = 0, size = 10) Pageable pageable)
			throws Exception {
		Response response = new Response();
		response.setStatus(ErrorConstants.SUCCESS.toString());
		response.setMessage("Past Bookings List");
		response.setData(bookingService.getPastBookingsByUser(userId, pageable));
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	

	
}

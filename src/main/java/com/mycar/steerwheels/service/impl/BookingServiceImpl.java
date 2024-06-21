package com.mycar.steerwheels.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mycar.steerwheels.bo.Response;
import com.mycar.steerwheels.constants.BookingStatus;
import com.mycar.steerwheels.constants.ErrorConstants;
import com.mycar.steerwheels.constants.PaymentStatus;
import com.mycar.steerwheels.entity.Booking;
import com.mycar.steerwheels.entity.Car;
import com.mycar.steerwheels.exception.SteerWheelsException;
import com.mycar.steerwheels.repository.BookingRepository;
import com.mycar.steerwheels.repository.CarRepository;
import com.mycar.steerwheels.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	private BookingRepository bookingRepo;
	
	@Autowired
	private CarRepository carRepo;

	@Override
	public Booking bookCab(Booking booking) throws Exception {
		//User user = getLoggedInUser();
		Car exiCar = carRepo.findById(booking.getCar().getCarId())
				 .orElseThrow(()-> new SteerWheelsException(ErrorConstants.NOT_FOUND.toString(), "Car not found"));
		long days = TimeUnit.DAYS.convert((booking.getReturnDate().getTime()-booking.getPickupDate().getTime()), TimeUnit.MILLISECONDS);
		BigDecimal totalRent = BigDecimal.valueOf(days).multiply(exiCar.getDailyRent());
		
		booking.setNoOfdays(days);
		booking.setBookingStatus(BookingStatus.Scheduled);
		booking.setPaymentStatus(PaymentStatus.Pending);
		//booking.setUser(user);
		booking.setTotalRent(totalRent);
		bookingRepo.save(booking);
		return booking;
	}

	@Override
	public void completeRental(UUID bookingId) throws Exception {
		Booking exiBooking = bookingRepo.findById(bookingId)
				.orElseThrow(()-> new SteerWheelsException(ErrorConstants.NOT_FOUND.toString(), "Booking Not Found") );
		exiBooking.setBookingStatus(BookingStatus.Completed);
		bookingRepo.save(exiBooking);
		
		Car exiCar = carRepo.findById(exiBooking.getCar().getCarId())
				.orElseThrow(()-> new SteerWheelsException(ErrorConstants.NOT_FOUND.toString(), "Car not found"));
		exiCar.setAvailable(true);
		carRepo.save(exiCar);
				
	}

	@Override
	public Response getBookingsByUser(UUID userId, Pageable pageable) throws Exception{
		Response response = new Response();
		Page<Booking> page = bookingRepo.getBookingsByUser(userId, pageable);
		response.setData(page.getContent());
		response.setListCount(page.getTotalElements());
		return response;
	}

	@Override
	public Response getAllBookings(String searchBy, Pageable pageable) throws Exception {
		Response response = new Response();
		Page<Booking> page = bookingRepo.getAllBookings(searchBy, pageable);
		response.setData(page.getContent());
		response.setListCount(page.getTotalElements());
		return response;
	}

	
	@Override
	public void cancelBooking(UUID bookingId) throws Exception {
		Booking exiBooking = bookingRepo.findById(bookingId)
				.orElseThrow(()-> new SteerWheelsException(ErrorConstants.NOT_FOUND.toString(), "Booking Not Found") );
		exiBooking.setBookingStatus(BookingStatus.Cancelled);
		bookingRepo.save(exiBooking);
		
		Car exiCar = carRepo.findById(exiBooking.getCar().getCarId())
				.orElseThrow(()-> new SteerWheelsException(ErrorConstants.NOT_FOUND.toString(), "Car not found"));
		exiCar.setAvailable(true);
		carRepo.save(exiCar);
				
	}

	@Override
	public Response getPastBookingsByUser(UUID userId, Pageable pageable) {
		Response response = new Response();
		Date date = new Date();
		Page<Booking> page = bookingRepo.getPastBookingsByUser(userId, date, pageable);
		response.setData(page.getContent());
		response.setListCount(page.getTotalElements());
		return response;
	}
}

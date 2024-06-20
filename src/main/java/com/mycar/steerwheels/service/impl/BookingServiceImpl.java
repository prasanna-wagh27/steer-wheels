package com.mycar.steerwheels.service.impl;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}

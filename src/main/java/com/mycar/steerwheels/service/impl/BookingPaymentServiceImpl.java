package com.mycar.steerwheels.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycar.steerwheels.constants.ErrorConstants;
import com.mycar.steerwheels.constants.PaymentStatus;
import com.mycar.steerwheels.entity.Booking;
import com.mycar.steerwheels.entity.BookingPayment;
import com.mycar.steerwheels.entity.Car;
import com.mycar.steerwheels.exception.SteerWheelsException;
import com.mycar.steerwheels.repository.BookingPaymentRepository;
import com.mycar.steerwheels.repository.BookingRepository;
import com.mycar.steerwheels.repository.CarRepository;
import com.mycar.steerwheels.service.BookingPaymentService;

@Service
public class BookingPaymentServiceImpl implements BookingPaymentService{

	
	@Autowired
	private BookingPaymentRepository bookingPaymentRepo;
	
	@Autowired
	private BookingRepository bookingRepo;
	
	@Autowired
	private CarRepository carRepo;
	
	@Override
	public void doBookingPayment(BookingPayment bookingPayment) throws Exception {
		bookingPaymentRepo.save(bookingPayment);
		
		Booking exiBooking = bookingRepo.findById(bookingPayment.getBooking().getBookingId())
				.orElseThrow((()-> new SteerWheelsException(ErrorConstants.NOT_FOUND.toString(), "Booking not found")));
		
		exiBooking.setPaymentStatus(PaymentStatus.Paid);
		bookingRepo.save(exiBooking);
		
		Car exiCar = carRepo.findById(exiBooking.getCar().getCarId()).get();
		
		exiCar.setAvailable(false);
		exiCar.setAvailableFrom(exiBooking.getReturnDate());
		
	}

}

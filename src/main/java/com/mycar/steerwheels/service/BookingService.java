package com.mycar.steerwheels.service;

import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.mycar.steerwheels.bo.Response;
import com.mycar.steerwheels.entity.Booking;

public interface BookingService {

	Booking bookCab(Booking booking) throws Exception;

	void completeRental(UUID bookingId) throws Exception;

	Response getBookingsByUser(UUID userId, Pageable pageable) throws Exception;

	Response getAllBookings(String searchBy, Pageable pageable) throws Exception;

	void cancelBooking(UUID bookingId) throws Exception;

	Response getPastBookingsByUser(UUID userId, Pageable pageable);

}

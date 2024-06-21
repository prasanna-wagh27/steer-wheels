package com.mycar.steerwheels.repository;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mycar.steerwheels.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, UUID>{

	@Query("SELECT b FROM Booking b WHERE b.user.userId = :userId")
	Page<Booking> getBookingsByUser(@Param("userId") UUID userId, Pageable pageable);

	@Query("SELECT b FROM Booking b WHERE :")
	Page<Booking> getAllBookings(@Param("searchBy") String searchBy, Pageable pageable);

	@Query("SELECT b FROM BOOKING b WHERE b.user.userId = : userId "
			+ " AND b.bookingDate < DATE(date)")
	Page<Booking> getPastBookingsByUser(@Param("userId") UUID userId, @Param("date") Date date, Pageable pageable);

}

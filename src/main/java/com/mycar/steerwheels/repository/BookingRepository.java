package com.mycar.steerwheels.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycar.steerwheels.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, UUID>{

}

package com.mycar.steerwheels.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycar.steerwheels.entity.BookingPayment;

public interface BookingPaymentRepository extends JpaRepository<BookingPayment, UUID>{

}

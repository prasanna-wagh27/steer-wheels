package com.mycar.steerwheels.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycar.steerwheels.entity.Car;

public interface CarRepository extends JpaRepository<Car, UUID>{

}

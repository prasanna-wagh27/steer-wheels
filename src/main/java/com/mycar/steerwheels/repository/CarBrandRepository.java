package com.mycar.steerwheels.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycar.steerwheels.entity.CarBrand;

public interface CarBrandRepository extends JpaRepository<CarBrand, UUID>{

	CarBrand findByCarBrandName(String carBrandName);

}

package com.mycar.steerwheels.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mycar.steerwheels.entity.CarBrand;

public interface CarBrandRepository extends JpaRepository<CarBrand, UUID>{

	CarBrand findByCarBrandName(String carBrandName);

	boolean existsByCarBrandName(String carBrandName);

	@Query("SELECT cb FROM CarBrand cb")
	Page<CarBrand> getAllCarBrands(Pageable pageable);

}

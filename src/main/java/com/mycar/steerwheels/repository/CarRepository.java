package com.mycar.steerwheels.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mycar.steerwheels.entity.Car;

public interface CarRepository extends JpaRepository<Car, UUID>{

	boolean existsByRegistrationNumber(String registrationNumber);

	@Query("SELECT c FROM Car c WHERE(:cityId IS NULL OR c.city.cityId = :cityId)")
	Page<Car> getAllCars(UUID cityId, Pageable pageable) throws Exception;

}

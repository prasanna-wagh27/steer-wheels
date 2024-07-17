package com.mycar.steerwheels.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mycar.steerwheels.entity.CarModel;

public interface CarModelRepository extends JpaRepository<CarModel, UUID>{

	boolean existsByName(String name);

	@Query("SELECT cm FROM CarModel cm")
	Page<CarModel> getAllCarModels(Pageable pageable);

}

package com.mycar.steerwheels.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mycar.steerwheels.entity.City;
import com.mycar.steerwheels.entity.State;

public interface CityRepository extends JpaRepository<City, UUID>{

	@Query("SELECT c FROM City c WHERE(:stateId IS NULL OR c.state.stateId = :stateId)")
	Page<City> getAllCitiesByState(@Param("stateId") UUID stateId, Pageable pageable);

	@Query("SELECT c FROM City c WHERE(:stateId IS NULL OR c.state.stateId = :stateId) "
			+ "AND c.status = true")
	Page<City> getActiveCities(UUID stateId, Pageable pageable);

	boolean existsByStateAndCityName(State state, String cityName);

}

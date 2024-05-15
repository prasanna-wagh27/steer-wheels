package com.mycar.steerwheels.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mycar.steerwheels.entity.Country;

public interface CountryRepository extends JpaRepository<Country, UUID>{

	boolean existsByCountryName(String countryName);

	@Query("SELECT c FROM Country c")
	Page<Country> getAllCountries(Pageable pageable);

	@Query("SELECT c FROM Country c  WHERE c.status = true")
	Page<Country> getActiveCountries(Pageable pageable);

}

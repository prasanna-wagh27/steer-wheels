package com.mycar.steerwheels.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycar.steerwheels.entity.Country;

public interface CountryRepository extends JpaRepository<Country, UUID>{

	boolean existsByCountryName(String countryName);

}

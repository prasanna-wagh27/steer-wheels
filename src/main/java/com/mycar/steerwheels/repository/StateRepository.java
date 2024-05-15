package com.mycar.steerwheels.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mycar.steerwheels.entity.Country;
import com.mycar.steerwheels.entity.State;

public interface StateRepository extends JpaRepository<State, UUID>{

	boolean existsByCountryAndStateName(Country country, String stateName);

	Page<State> findByCountry(Country exiCountry, Pageable pageable);

	Page<State> findByCountryAndStatus(Country exiCountry, boolean status, Pageable pageable);

}

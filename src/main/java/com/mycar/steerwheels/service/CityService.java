package com.mycar.steerwheels.service;

import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.mycar.steerwheels.bo.Response;
import com.mycar.steerwheels.entity.City;

public interface CityService {

	void addCity(City city) throws Exception;

	Response getAllCitiesByState(UUID stateId, Pageable pageable) throws Exception;

	Response getActiveCities(UUID stateId, Pageable pageable) throws Exception;

	City getCityById(UUID cityId) throws Exception;

	void updateCity(UUID cityId, City city) throws Exception;

}

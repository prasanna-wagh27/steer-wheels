package com.mycar.steerwheels.service;

import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.mycar.steerwheels.bo.Response;
import com.mycar.steerwheels.entity.Country;

public interface CountryService {

	void addCountry(Country country) throws Exception;

	Response getAllCountries(Pageable pageable) throws Exception;

	Response getActiveCountries(Pageable pageable) throws Exception;

	Country getCountryById(UUID countryId) throws Exception;

	void updateCountry(UUID countryId, Country country) throws Exception;

}

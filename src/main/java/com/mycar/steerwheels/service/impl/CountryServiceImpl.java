package com.mycar.steerwheels.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycar.steerwheels.constants.ErrorConstants;
import com.mycar.steerwheels.entity.Country;
import com.mycar.steerwheels.exception.SteerWheelsException;
import com.mycar.steerwheels.repository.CountryRepository;
import com.mycar.steerwheels.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService{
	
	@Autowired
	private CountryRepository countryRepo;

	@Override
	public void addCountry(Country country) throws Exception {
		
		if(countryRepo.existsByCountryName(country.getCountryName())) {
			throw new SteerWheelsException(ErrorConstants.INVALID.toString(), "Country with this name already exists");
		}
		
		countryRepo.save(country);
		
	}

}

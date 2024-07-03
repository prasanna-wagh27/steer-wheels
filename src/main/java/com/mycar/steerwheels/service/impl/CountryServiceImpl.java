package com.mycar.steerwheels.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mycar.steerwheels.bo.Response;
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

	@Override
	public Response getAllCountries(Pageable pageable) throws Exception {		
		Page<Country> page = countryRepo.getAllCountries(pageable);		
		Response response = new Response();
		response.setData(page.getContent());
		response.setListCount(page.getTotalElements());
		return response;
	}

	@Override
	public Response getActiveCountries(Pageable pageable) throws Exception {
		Page<Country> page = countryRepo.getActiveCountries(pageable);		
		Response response = new Response();
		response.setData(page.getContent());
		response.setListCount(page.getTotalElements());
		return response;
	}

	@Override
	public Country getCountryById(UUID countryId) throws Exception {
		Country exiCountry = countryRepo.findById(countryId)
				.orElseThrow( ()-> new SteerWheelsException(ErrorConstants.NOT_FOUND.toString(), "Country Not Found"));
		return exiCountry;
	}

	@Override
	public void updateCountry(UUID countryId, Country country) throws Exception {

		Country exiCountry = countryRepo.findById(countryId)
				.orElseThrow( ()-> new SteerWheelsException(ErrorConstants.NOT_FOUND.toString(), "Country Not Found"));
		
		exiCountry.setCountryName(country.getCountryName());
		exiCountry.setStatus(country.isStatus());
		countryRepo.save(exiCountry);
	}

}

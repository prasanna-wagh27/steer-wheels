package com.mycar.steerwheels.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mycar.steerwheels.bo.Response;
import com.mycar.steerwheels.constants.ErrorConstants;
import com.mycar.steerwheels.entity.City;
import com.mycar.steerwheels.entity.State;
import com.mycar.steerwheels.exception.SteerWheelsException;
import com.mycar.steerwheels.repository.CityRepository;
import com.mycar.steerwheels.repository.StateRepository;
import com.mycar.steerwheels.service.CityService;

@Service
public class CityServiceImpl implements CityService{

	@Autowired
	private CityRepository cityRepo;
	
	@Autowired
	private StateRepository stateRepo;
	
	@Override
	public void addCity(City city) throws Exception {
		State exiState = stateRepo.findById(city.getState().getStateId())
				.orElseThrow(()-> new SteerWheelsException(ErrorConstants.NOT_FOUND.toString(), "State not found"));
		if(cityRepo.existsByStateAndCityName(exiState, city.getCityName())) {
			throw new SteerWheelsException(ErrorConstants.INVALID.toString(), "City with this name already exists");
		}
		cityRepo.save(city);		
	}

	@Override
	public Response getAllCitiesByState(UUID stateId, Pageable pageable) throws Exception {
		Response response = new Response();		
		Page<City> page = cityRepo.getAllCitiesByState(stateId, pageable);
		response.setData(page.getContent());
		response.setListCount(page.getTotalElements());
		return response;
	}

	@Override
	public Response getActiveCities(UUID stateId, Pageable pageable) throws Exception {
		Response response = new Response();
		
		Page<City> page = cityRepo.getActiveCities(stateId, pageable);
		response.setData(page.getContent());
		response.setListCount(page.getTotalElements());
		return response;
	}

	@Override
	public City getCityById(UUID cityId) throws Exception {
		return cityRepo.findById(cityId)
				.orElseThrow(()-> new SteerWheelsException(ErrorConstants.NOT_FOUND.toString(), "Invalid statyeId"));
	}

	@Override
	public void updateCity(UUID cityId, City city) throws Exception {
		City exiCity = getCityById(cityId);
		State exiState = stateRepo.findById(city.getState().getStateId())
				.orElseThrow(()-> new SteerWheelsException(ErrorConstants.NOT_FOUND.toString(), "State not found"));
		
		if(cityRepo.existsByStateAndCityName(exiState, city.getCityName()) && !city.getCityName().equals(exiCity.getCityName())) {
			throw new SteerWheelsException(ErrorConstants.INVALID.toString(), "City with this name already exists");
		}
		exiCity.setCityName(city.getCityName());
		exiCity.setState(city.getState());
		exiCity.setStatus(city.getStatus());
		cityRepo.save(exiCity);
	}

}

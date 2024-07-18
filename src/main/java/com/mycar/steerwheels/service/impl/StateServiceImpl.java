package com.mycar.steerwheels.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mycar.steerwheels.bo.Response;
import com.mycar.steerwheels.constants.ErrorConstants;
import com.mycar.steerwheels.entity.Country;
import com.mycar.steerwheels.entity.State;
import com.mycar.steerwheels.exception.SteerWheelsException;
import com.mycar.steerwheels.repository.CountryRepository;
import com.mycar.steerwheels.repository.StateRepository;
import com.mycar.steerwheels.service.StateService;

@Service
public class StateServiceImpl implements StateService{

	@Autowired
	private StateRepository stateRepo;
	
	@Autowired
	private CountryRepository countryRepo;

	@Override
	public void addState(State state) throws Exception {
		Country exiCountry = countryRepo.findById(state.getCountry().getCountryId())
				.orElseThrow(()-> new SteerWheelsException(ErrorConstants.NOT_FOUND.toString(), "Country not found"));
		if(stateRepo.existsByCountryAndStateName(state.getCountry(), state.getStateName())) {
			throw new SteerWheelsException(ErrorConstants.INVALID.toString(), "State with this name already exists");
		}
		state.setCountry(exiCountry);
		stateRepo.save(state);
	}

	@Override
	public Response getAllStatesByCountry(UUID countryId, Pageable pageable) throws Exception{
		Response response = new Response();
		Country exiCountry = countryRepo.findById(countryId)
				.orElseThrow(() -> new SteerWheelsException(ErrorConstants.NOT_FOUND.toString(), "Country not found"));
		Page<State> page = stateRepo.findByCountry(exiCountry, pageable);
		
		response.setData(page.getContent());
		response.setListCount(page.getTotalElements());
		return response;
	}

	@Override
	public Response getActiveStatesByCountry(UUID countryId, Pageable pageable) throws Exception {
		Response response = new Response();
		Country exiCountry = countryRepo.findById(countryId)
				.orElseThrow(() -> new SteerWheelsException(ErrorConstants.NOT_FOUND.toString(), "Country not found"));
		Page<State> page = stateRepo.findByCountryAndStatus(exiCountry, true, pageable);
		
		response.setData(page.getContent());
		response.setListCount(page.getTotalElements());
		return response;
	}

	@Override
	public State getStateById(UUID stateId) throws Exception {
		State exiState = stateRepo.findById(stateId)
				.orElseThrow(() -> new SteerWheelsException(ErrorConstants.NOT_FOUND.toString(), "State not found"));
		return exiState;
	}

	@Override
	public void updateState(UUID stateId, State state) throws Exception {

		State exiState = stateRepo.findById(stateId)
				.orElseThrow(() -> new SteerWheelsException(ErrorConstants.NOT_FOUND.toString(), "State not found"));
		exiState.setStateName(state.getStateName());
		exiState.setStatus(state.getStatus());
		stateRepo.save(exiState);
	}
}

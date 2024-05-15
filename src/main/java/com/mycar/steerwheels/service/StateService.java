package com.mycar.steerwheels.service;

import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.mycar.steerwheels.bo.Response;
import com.mycar.steerwheels.entity.State;

public interface StateService {

	void addState(State state) throws Exception;

	Response getAllStatesByCountry(UUID countryId, Pageable pageable) throws Exception;

	Response getActiveStatesByCountry(UUID countryId, Pageable pageable) throws Exception;

	State getStateById(UUID stateId) throws Exception;

	void updateState(UUID stateId, State state) throws Exception;


}

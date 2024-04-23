package com.mycar.steerwheels.service.impl;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycar.steerwheels.bo.UserBO;
import com.mycar.steerwheels.constants.ErrorConstants;
import com.mycar.steerwheels.constants.Roles;
import com.mycar.steerwheels.entity.Address;
import com.mycar.steerwheels.entity.Role;
import com.mycar.steerwheels.entity.User;
import com.mycar.steerwheels.exception.SteerWheelsException;
import com.mycar.steerwheels.repository.AddressRepository;
import com.mycar.steerwheels.repository.RoleRepository;
import com.mycar.steerwheels.repository.UserRepository;
import com.mycar.steerwheels.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private AddressRepository addressRepo;

	@Override
	public void validateMobileNumber(String mobileNumber) throws Exception {
		User exiUser = userRepo.findByMobileNumber();
		if(null == exiUser) {
			throw new SteerWheelsException(ErrorConstants.INVALID.toString(), "This number is already registered. Please Login");
		}
		User user = new User();
		user.setOtp(new Random().nextInt(6));
			
		Role role = roleRepo.findByRole(Roles.PASSENGER);
			
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, 0);
		user.setOtpExpiryTime(calendar.getTime());
		user.setOtpVerifyStatus(false);
		user.setMobileNumber(mobileNumber);
		user.setRole(role);
		user.setProfileCompletionStatus(false);
		userRepo.save(user);
	}
	
	@Override
	public User verifyOtp(UserBO customerBO) throws Exception {
		User customer = userRepo.findByMobileNumber(customerBO.getMobileNumber());
		
		if(customerBO.getOtp() != customer.getOtp()) {
			 throw new SteerWheelsException(ErrorConstants.INVALID.toString(), "Invalid OTP.");
		}
		
		LocalDate date = LocalDate.now();     
	    Date currentTime = java.sql.Date.valueOf(date);
	    
		if(customer.getOtpExpiryTime().after(currentTime)) {
			throw new SteerWheelsException(ErrorConstants.INVALID.toString(), "OTP Expired.");
		}
		
		//Logic for session token generation
		
		customer.setOtpVerifyStatus(true);
		customer.setLoginEnabled(true);
		
		return customer;
	}

	@Override
	public void registerCustomer(UserBO customerBO) throws Exception {
		User customer = userRepo.findByMobileNumber(customerBO.getMobileNumber());
		if(null != customerBO.getAddress()) {
			Address address = customerBO.getAddress();
			addressRepo.save(address);
		}
		customer.setEmail(customerBO.getEmail());
		customer.setDateOfBirth(customerBO.getDateOfBirth());
		customer.setFullName(customerBO.getFullName());
		
		//Logic to save driving licence image
		
		userRepo.save(customer);
		
	}

	
}

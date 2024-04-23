package com.mycar.steerwheels.service;

import com.mycar.steerwheels.bo.UserBO;
import com.mycar.steerwheels.entity.User;

public interface CustomerService {

	void validateMobileNumber(String mobileNumber) throws Exception;

	void registerCustomer(UserBO userBO) throws Exception;

	User verifyOtp(UserBO userBO) throws Exception;

}

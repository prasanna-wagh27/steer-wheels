package com.mycar.steerwheels.bo;

import java.util.Date;

import com.mycar.steerwheels.constants.Gender;
import com.mycar.steerwheels.entity.Address;
import com.mycar.steerwheels.entity.Role;

public class UserBO {

private String fullName;
	
	private String mobileNumber;
	
	private String email;
	
	private Date dateOfBirth;
	
	private Address address;
	
	private Gender gender;
	
	private Role role;
	
	private int otp;

	private Date otpVerifyTime;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	public Date getOtpVerifyTime() {
		return otpVerifyTime;
	}

	public void setOtpVerifyTime(Date otpVerifyTime) {
		this.otpVerifyTime = otpVerifyTime;
	}

}

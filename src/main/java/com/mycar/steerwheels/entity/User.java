package com.mycar.steerwheels.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;

import com.mycar.steerwheels.constants.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name = "user")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -456720917411679910L;

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	@JdbcTypeCode(java.sql.Types.VARCHAR)
	private UUID userId;
	
	@Column(name = "full_name", nullable = false)
	private String fullName;
	
	@Column(name = "mobile_number", nullable = false, unique = true)
	private String mobileNumber;
	
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_birth", nullable = false)
	private Date dateOfBirth;
	
	@OneToOne(targetEntity = Address.class)
	@JoinColumn(name = "address_id")
	@JdbcTypeCode(java.sql.Types.VARCHAR)
	private Address address;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	private Gender gender;
	
	@JoinColumn(name = "role_id")
	@ManyToOne(targetEntity = Role.class)
	@JdbcTypeCode(java.sql.Types.VARCHAR)
	private Role role;
	
	@Column(name = "otp")
	private int otp;
	
	@Column(name = "otp_expiry_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date otpExpiryTime;
	
	@Column(name = "otp_verify_status", columnDefinition = "BOOLEAN DEFAULT FALSE")
	private boolean otpVerifyStatus;
	
	@Column(name = "driving_licence_image")
	private String drivingLicenceImage;
	
	@Transient
	private String encodedDrivingLicenseImage;
	
	@Column(name = "profile_completion_status", columnDefinition = "BOOLEAN DEFAULT FALSE")
	private boolean profileCompletionStatus;
	
	@Column(name = "is_login_enabled", columnDefinition = "BOOLEAN DEFAULT FALSE")
	private boolean isLoginEnabled;

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

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

	public Date getOtpExpiryTime() {
		return otpExpiryTime;
	}

	public void setOtpExpiryTime(Date otpExpiryTime) {
		this.otpExpiryTime = otpExpiryTime;
	}

	public boolean isOtpVerifyStatus() {
		return otpVerifyStatus;
	}

	public void setOtpVerifyStatus(boolean otpVerifyStatus) {
		this.otpVerifyStatus = otpVerifyStatus;
	}

	public String getDrivingLicenceImage() {
		return drivingLicenceImage;
	}

	public void setDrivingLicenceImage(String drivingLicenceImage) {
		this.drivingLicenceImage = drivingLicenceImage;
	}

	public String getEncodedDrivingLicenseImage() {
		return encodedDrivingLicenseImage;
	}

	public void setEncodedDrivingLicenseImage(String encodedDrivingLicenseImage) {
		this.encodedDrivingLicenseImage = encodedDrivingLicenseImage;
	}

	public boolean isProfileCompletionStatus() {
		return profileCompletionStatus;
	}

	public void setProfileCompletionStatus(boolean profileCompletionStatus) {
		this.profileCompletionStatus = profileCompletionStatus;
	}

	public boolean isLoginEnabled() {
		return isLoginEnabled;
	}

	public void setLoginEnabled(boolean isLoginEnabled) {
		this.isLoginEnabled = isLoginEnabled;
	}
	
}

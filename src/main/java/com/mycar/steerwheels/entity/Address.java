package com.mycar.steerwheels.entity;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "address")
public class Address implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5279077254146092191L;
	
	@Id
	@GeneratedValue
	@Column(name = "address_id", nullable = false)
	@JdbcTypeCode(java.sql.Types.VARCHAR)
	private UUID addressId;
	
	@Column(name = "address_line_one", nullable = false)
	private String addressLineOne;
	
	@Column(name = "address_line_two", nullable = false)
	private String addressLineTwo;
	
	@ManyToOne(targetEntity = Country.class)
	@JoinColumn(name = "country_id", nullable = false)
	@JdbcTypeCode(java.sql.Types.VARCHAR)
	private Country country;
	
	@ManyToOne(targetEntity = State.class)
	@JoinColumn(name = "state_id", nullable = false)
	@JdbcTypeCode(java.sql.Types.VARCHAR)
	private State state;
	
	@ManyToOne(targetEntity = City.class)
	@JoinColumn(name = "city_id", nullable = false)
	@JdbcTypeCode(java.sql.Types.VARCHAR)
	private City city;
	
	@Column(name = "pin_code", nullable = false)
	private String pinCode;

	public UUID getAddressId() {
		return addressId;
	}

	public void setAddressId(UUID addressId) {
		this.addressId = addressId;
	}

	public String getAddressLineOne() {
		return addressLineOne;
	}

	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	public String getAddressLineTwo() {
		return addressLineTwo;
	}

	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	
	

}

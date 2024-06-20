package com.mycar.steerwheels.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "car")
public class Car implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4364823331814907018L;

	@Id
	@GeneratedValue
	@Column(name = "car_id")
	@JdbcTypeCode(java.sql.Types.VARCHAR)
	private UUID carId;
	
	@JoinColumn(name = "car_model")
	@ManyToOne(targetEntity = CarModel.class)
	@JdbcTypeCode(java.sql.Types.VARCHAR)
	private CarModel carModel;
	
	@Column(name = "registration_number")
	private String registrationNumber;
	
	@Column(name = "year")
	private int year;
	
	@Column(name = "daily_rent")
	private BigDecimal dailyRent;
	
	@Column(name = "is_available", columnDefinition = "BOOLEAN DEFAULT TRUE")
	private boolean isAvailable;
	
	@Column(name = "available_from")
	@Temporal(TemporalType.DATE)
	private Date availableFrom;
	
	@Column(name = "available_from")
	@Temporal(TemporalType.DATE)
	private Date available;

	public UUID getCarId() {
		return carId;
	}

	public void setCarId(UUID carId) {
		this.carId = carId;
	}

	public CarModel getCarModel() {
		return carModel;
	}

	public void setCarModel(CarModel carModel) {
		this.carModel = carModel;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public BigDecimal getDailyRent() {
		return dailyRent;
	}

	public void setDailyRent(BigDecimal dailyRent) {
		this.dailyRent = dailyRent;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Date getAvailableFrom() {
		return availableFrom;
	}

	public void setAvailableFrom(Date availableFrom) {
		this.availableFrom = availableFrom;
	}
	

}

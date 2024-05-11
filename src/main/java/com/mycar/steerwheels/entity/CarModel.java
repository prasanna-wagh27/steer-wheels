package com.mycar.steerwheels.entity;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;

import com.mycar.steerwheels.constants.CarType;
import com.mycar.steerwheels.constants.FuelType;
import com.mycar.steerwheels.constants.TransmissionType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "car_model")
public class CarModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2708472724188621133L;
	
	@Id
	@GeneratedValue
	@Column(name = "car_model_id")
	@JdbcTypeCode(java.sql.Types.VARCHAR)
	private UUID carModelId;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "car_type")
	private CarType carType;
	
	@Column(name = "name")
	private String name;
	
	@JoinColumn(name = "car_brand_id")
	@ManyToOne(targetEntity = CarBrand.class)
	@JdbcTypeCode(java.sql.Types.VARCHAR)
	private CarBrand carBrand;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "fuel_type")
	private FuelType fuelType;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "transmission_type")
	private TransmissionType transmissionType;
	
	@Column(name = "seating_capacity")
	private int seatingCapacity;
	
	@Column(name = "car_model_image")
	private String carModelImage;
	
	@Transient
	private String encodedCarModelImage;

	public UUID getCarModelId() {
		return carModelId;
	}

	public void setCarModelId(UUID carModelId) {
		this.carModelId = carModelId;
	}

	public CarType getCarType() {
		return carType;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CarBrand getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(CarBrand carBrand) {
		this.carBrand = carBrand;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}

	public TransmissionType getTransmissionType() {
		return transmissionType;
	}

	public void setTransmissionType(TransmissionType transmissionType) {
		this.transmissionType = transmissionType;
	}

	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	public String getCarModelImage() {
		return carModelImage;
	}

	public void setCarModelImage(String carModelImage) {
		this.carModelImage = carModelImage;
	}

	public String getEncodedCarModelImage() {
		return encodedCarModelImage;
	}

	public void setEncodedCarModelImage(String encodedCarModelImage) {
		this.encodedCarModelImage = encodedCarModelImage;
	}
	
}

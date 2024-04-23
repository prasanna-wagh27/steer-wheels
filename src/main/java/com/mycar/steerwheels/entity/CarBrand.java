package com.mycar.steerwheels.entity;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "car_brand")
public class CarBrand implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -207498476321528698L;

	@Id
	@GeneratedValue
	@Column(name = "car_brand_id")
	@JdbcTypeCode(java.sql.Types.VARCHAR)
	private UUID carBrandId;
	
	@Column(name = "car_brand_name")
	private String carBrandName;

	public UUID getCarBrandId() {
		return carBrandId;
	}

	public void setCarBrandId(UUID carBrandId) {
		this.carBrandId = carBrandId;
	}

	public String getCarBrandName() {
		return carBrandName;
	}

	public void setCarBrandName(String carBrandName) {
		this.carBrandName = carBrandName;
	}
	
	

}

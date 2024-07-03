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
@Table(name = "country")
public class Country implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5591158187650897590L;
	
	@Id
	@GeneratedValue
	@Column(name = "countrt_id")
	@JdbcTypeCode(java.sql.Types.VARCHAR)
	private UUID countryId;

	@Column(name = "country_name", nullable = false)
	private String countryName;
	
	@Column(name = "status", columnDefinition = "BOOLEAN DEFAULT FALSE")
	private boolean status;
	

	public UUID getCountryId() {
		return countryId;
	}

	public void setCountryId(UUID countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}

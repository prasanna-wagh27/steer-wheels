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
@Table(name = "city")
public class City implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4752446384835114191L;
	
	@Id
	@GeneratedValue
	@Column(name = "city_id")
	@JdbcTypeCode(java.sql.Types.VARCHAR)
	private UUID cityId;
	
	@Column(name = "city_name", nullable = false)
	private String cityName;

	@ManyToOne(targetEntity = State.class)
	@JoinColumn(name = "state_id", nullable = false)
	@JdbcTypeCode(java.sql.Types.VARCHAR)
	private State state;
	
	@Column(name = "status", columnDefinition = "BOOLEAN DEFAULT FALSE")
	private boolean status;

	public UUID getCityId() {
		return cityId;
	}

	public void setCityId(UUID cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}

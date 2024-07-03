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
@Table(name = "state")
public class State implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1785112499940650106L;

	@Id
	@GeneratedValue
	@Column(name = "state_id")
	@JdbcTypeCode(java.sql.Types.VARCHAR)
	private UUID stateId;
	
	@Column( name = "state_name")
	private String stateName;
	
	@ManyToOne(targetEntity = Country.class)
	@JoinColumn(name = "country_id")
	@JdbcTypeCode(java.sql.Types.VARCHAR)
	private Country country;
	
	@Column(name = "status", columnDefinition = "BOOLEAN DEFAULT FALSE")
	private boolean status;

	public UUID getStateId() {
		return stateId;
	}

	public void setStateId(UUID stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}	
	
}

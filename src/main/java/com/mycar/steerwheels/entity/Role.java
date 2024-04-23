package com.mycar.steerwheels.entity;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;

import com.mycar.steerwheels.constants.Roles;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "role")
public class Role implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6831321736223503820L;
	
	@Id
	@GeneratedValue
	@Column(name = "role_id")
	@JdbcTypeCode(java.sql.Types.VARCHAR)
	private UUID roleId;
	
	@Column(name = "name")
	private String roleName;
	
	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private Roles role;

	public UUID getRoleId() {
		return roleId;
	}

	public void setRoleId(UUID roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

}

package com.mycar.steerwheels.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycar.steerwheels.constants.Roles;
import com.mycar.steerwheels.entity.Role;

public interface RoleRepository extends JpaRepository<Role, UUID>{

	Role findByRole(Roles passenger);

}

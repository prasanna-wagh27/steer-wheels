package com.mycar.steerwheels.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycar.steerwheels.entity.User;

public interface UserRepository extends JpaRepository<User, UUID>{

	User findByMobileNumber();

	User findByMobileNumber(String mobileNumber);

}

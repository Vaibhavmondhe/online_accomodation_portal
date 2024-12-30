package com.portal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.entities.OTP;

public interface OTPRepository extends JpaRepository<OTP, Long> {


	OTP findByEmail(String email);
}

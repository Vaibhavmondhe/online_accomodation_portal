package com.portal.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "OTP")
@Getter
@Setter
public class OTP {
	@Id
	@Column(length = 40)
	private String email;


	@CreationTimestamp
	private LocalDate paymentDate = LocalDate.now();


	@Column(length = 50)
	private String otp;

	public LocalDateTime getCreationTime() {
		return null;
	}

}


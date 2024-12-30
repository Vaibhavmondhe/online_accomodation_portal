package com.portal.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import com.portal.entities.Gender;
import com.portal.entities.Status;
import com.portal.entities.UserRole;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserUpdateDTO {

	private Long id;

	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	private long mobileNo;

	@Email
	private String email;

//	@JsonProperty(access = Access.WRITE_ONLY)
//	private String confirmPassword;

	private String address;

//	@JsonProperty(access = Access.READ_ONLY)
//	private Status status = Status.PENDING;
}

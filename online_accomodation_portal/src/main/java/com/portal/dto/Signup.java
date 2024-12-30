package com.portal.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.portal.entities.Gender;
import com.portal.entities.Status;
import com.portal.entities.UserRole;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Signup {
	@JsonProperty(access = Access.READ_ONLY) // this property only used during ser.
	private Long id;
	@NotBlank(message = "First Name required")
	private String firstName;
	private String lastName;
	@Email(message = "Invalid Email!!!")
	private String email;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	private UserRole role;

	private long mobileNo;

	private String address;

	private Gender gender;

	@JsonProperty(access = Access.READ_ONLY)
	private Status status = Status.PENDING;

}

package com.portal.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class LoginDto {
	
	@NotBlank(message="Email cannot be blank")
	@Email(message="Invalid E-mail format")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String email;
	
	@NotBlank(message="password cannot be blank")
	@Length(min = 8 , max = 15,message = "Invalid password Lenght")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}

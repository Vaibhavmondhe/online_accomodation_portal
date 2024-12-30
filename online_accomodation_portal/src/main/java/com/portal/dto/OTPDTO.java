package com.portal.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OTPDTO {
	@NotBlank
	private String email;
	@NotBlank
	private String password;
	@NotBlank
	private String fullName;
	@NotBlank
	private long mobNo;
	private String address;
}


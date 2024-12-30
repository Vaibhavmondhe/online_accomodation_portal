package com.portal.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ForgetPassOtpDTO {
	@NotBlank
	private String email;

	public ForgetPassOtpDTO() {
		// TODO Auto-generated constructor stub
	}
}
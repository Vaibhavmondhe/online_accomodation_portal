package com.portal.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EditPasswordDTO {
	private Long id;
	private String newpaasword;
	private String oldpassword;

}

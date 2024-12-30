package com.portal.dto;

import com.portal.entities.Status;
import com.portal.entities.UserRole;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ApprovedDTO {
	private Long id;
	private UserRole role;
	private Status status;
}

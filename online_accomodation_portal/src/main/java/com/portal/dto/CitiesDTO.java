package com.portal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//used for show list of cities
public class CitiesDTO {

	private Long id;

	private String cityName;

	private String state;

	private int pincode;
}

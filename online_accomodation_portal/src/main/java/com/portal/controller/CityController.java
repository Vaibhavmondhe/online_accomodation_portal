package com.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.dto.CitiesDTO;
import com.portal.service.CityService;

@RestController
@RequestMapping("/cities")
public class CityController {

	@Autowired
	private CityService cityService;

	public CityController() {
		System.out.println("in a cotr " + getClass());
	}

	// http://localhost:7070/cities
	@GetMapping
	public List<CitiesDTO> getCities() {
		return cityService.getAllCities();
	}

	// http://localhost:7070/cities/{cityId}
	@GetMapping("/{cityId}")

	public CitiesDTO getCityById(@PathVariable Long cityId) {
		return cityService.getCityById(cityId);
	}
	
	@GetMapping("findby/{cityName}")
	public CitiesDTO getCityByName(@PathVariable String cityName) {
		return cityService.getCityByName(cityName);
	}

}

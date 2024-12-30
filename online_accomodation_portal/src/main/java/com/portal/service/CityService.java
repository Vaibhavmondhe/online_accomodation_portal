package com.portal.service;

import java.util.List;

import com.portal.dto.AddCityDTO;
import com.portal.dto.ApiResponse;
import com.portal.dto.CitiesDTO;

public interface CityService {

	public List<CitiesDTO> getAllCities();

	public ApiResponse addNewCity(AddCityDTO citydto);

	public CitiesDTO getCityById(Long cityId);

	public CitiesDTO updateCity(CitiesDTO citydto);

	public CitiesDTO getCityByName(String cityName);

}

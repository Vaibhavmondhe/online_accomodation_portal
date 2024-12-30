package com.portal.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portal.dao.CityRepository;
import com.portal.dto.AddCityDTO;
import com.portal.dto.ApiResponse;
import com.portal.dto.CitiesDTO;
import com.portal.entities.City;
import com.portal.exception.CustomException;

@Service
@Transactional
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepository cityRepo;

	@Autowired
	private ModelMapper mapper;

	public CityServiceImpl() {
	}

	@Override
	public List<CitiesDTO> getAllCities() {

		List<CitiesDTO> citiesDTOList = new ArrayList<CitiesDTO>();
		List<City> list = cityRepo.findAll();
		citiesDTOList = Arrays.asList(mapper.map(list, CitiesDTO[].class));
		/*
		 * Arrays.asList(...), which creates a List object from the provided array. The
		 * Arrays.asList(...) method takes an array as an argument and returns a List
		 * object containing the elements of the array.
		 */
		return citiesDTOList;
	}

	@Override
	public CitiesDTO getCityById(Long cityId) {
		City city = cityRepo.findById(cityId).orElseThrow(() -> new CustomException("Invalid Id"));
		return mapper.map(city, CitiesDTO.class);
	}

	@Override
	public ApiResponse addNewCity(AddCityDTO citydto) {

		City newCity = mapper.map(citydto, City.class);

		if (newCity != null) {
			cityRepo.save(newCity);
			return new ApiResponse("New City added Successfully");
		}

		return new ApiResponse("Error while adding New City");
	}

	@Override
	public CitiesDTO updateCity(CitiesDTO citydto) {
		City city = mapper.map(citydto, City.class);

		cityRepo.save(city);
		return mapper.map(city, CitiesDTO.class);
	}

	@Override
	public CitiesDTO getCityByName(String cityName) {
		City cityEntity = cityRepo.findByCityName(cityName);

		return mapper.map(cityEntity, CitiesDTO.class);
	}

}

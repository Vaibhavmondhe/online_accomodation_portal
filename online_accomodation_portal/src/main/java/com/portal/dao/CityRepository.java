package com.portal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.entities.City;

public interface CityRepository extends JpaRepository<City, Long> {

	City findByCityName(String cityName);

}

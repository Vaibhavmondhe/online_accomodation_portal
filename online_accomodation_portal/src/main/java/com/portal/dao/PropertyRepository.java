package com.portal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.dto.PropertyResponseDto;
import com.portal.entities.City;
import com.portal.entities.Property;
import com.portal.entities.User;

public interface PropertyRepository extends JpaRepository<Property, Long> {

	List<Property> findByCityAndIsAvailable(City cityEntity, boolean bool);

	List<Property> findByUser(User user);

}

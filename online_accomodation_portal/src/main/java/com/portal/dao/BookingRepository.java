package com.portal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.entities.PropertyBooking;

public interface BookingRepository extends JpaRepository<PropertyBooking,Long> {

}

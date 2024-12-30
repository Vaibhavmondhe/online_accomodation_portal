package com.portal.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.dao.BookingRepository;
import com.portal.dao.PropertyRepository;
import com.portal.dao.UserDao;
import com.portal.entities.Property;
import com.portal.entities.PropertyBooking;
import com.portal.entities.User;
import com.portal.exception.CustomException;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepo;
	@Autowired
	private UserDao userDao;

	@Autowired
	private PropertyRepository propertyRepo;

	@Override
	public String bookProperty(Long userId, Long propertyId) {
		PropertyBooking propertyBooking = new PropertyBooking();
		User user = userDao.findById(userId).orElseThrow(() -> new CustomException("Invalid User"));
		Property property = propertyRepo.findById(propertyId)
				.orElseThrow(() -> new CustomException("Invalid Property"));
		System.out.println("in booking service" + property.getIsAvailable());
		if (property.getIsAvailable()) {

			propertyBooking.setFlatCategoryId(property.getCategory());
			propertyBooking.setPropertyId(property);
			propertyBooking.setUserId(user);
			;
			bookingRepo.save(propertyBooking);
			property.setIsAvailable(false);
			propertyRepo.save(property);
			propertyBooking.setBookingDateTime(LocalDateTime.now());
			return "Property Booking Successfully Done";
		} else {
			return "Property Booking Not Available Already Booked";
		}

	}

}

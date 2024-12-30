package com.portal.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "property_booking")
public class PropertyBooking extends BaseEntity{

	@OneToOne
	@JoinColumn(name = "flat_Category_id")
	private FlatCategory flatCategoryId;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User userId;

	@OneToOne
	@JoinColumn(name = "property_id")
	private Property propertyId;

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@Column(name = "booking_date_time")
	private LocalDateTime bookingDateTime;

	public PropertyBooking() {

	}

	public FlatCategory getFlatCategoryId() {
		return flatCategoryId;
	}

	public void setFlatCategoryId(FlatCategory flatCategoryId) {
		this.flatCategoryId = flatCategoryId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Property getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Property propertyId) {
		this.propertyId = propertyId;
	}

	public LocalDateTime getBookingDateTime() {
		return bookingDateTime;
	}

	public void setBookingDateTime(LocalDateTime bookingDateTime) {
		this.bookingDateTime = bookingDateTime;
	}

}

package com.portal.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

	@Column(name = "first_name", length = 30, nullable = false)
	private String firstName;

	@Column(name = "last_name", length = 30)
	private String lastName;

	@Column(name = "mobile_no", nullable = false)
	private long mobileNo;

	@Column(name = "email_id", unique = true, nullable = false)
	private String email;

	@Column(name = "password", length = 100, nullable = false)
	private String password;

	@Column(length = 50)
	private String address;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Property> propertyList;

	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PropertyBooking> bookingList;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PropertyReview> reviewList;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private UserRole role;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private Status status;

	public User() {
		this.bookingList = new ArrayList<PropertyBooking>();
		this.reviewList = new ArrayList<PropertyReview>();
		this.propertyList = new ArrayList<Property>();
	}

	
	
	public User(String firstName, String lastName, long mobileNo, String email, String password, String address,
			Gender gender, UserRole role, Status status) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.email = email;
		this.password = password;
		this.address = address;
		this.gender = gender;
		this.role = role;
		this.status = status;
	}



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Property> getPropertyList() {
		return propertyList;
	}

	public void setPropertyList(List<Property> propertyList) {
		this.propertyList = propertyList;
	}

	public List<PropertyBooking> getBookingList() {
		return bookingList;
	}

	public void setBookingList(List<PropertyBooking> bookingList) {
		this.bookingList = bookingList;
	}

	public List<PropertyReview> getReviewList() {
		return reviewList;
	}

	public void setReviewList(List<PropertyReview> reviewList) {
		this.reviewList = reviewList;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}

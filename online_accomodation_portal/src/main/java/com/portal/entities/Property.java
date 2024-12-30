package com.portal.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.type.TrueFalseType;

@Entity
@Table(name = "property_details")
public class Property extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "flat_category_id")
	private FlatCategory category;

	@Column(length = 150)
	private String instructions;

	@Column(name = "status")
	private Boolean isAvailable;

	private int deposit;

	private int rent;
	@Column(length = 75)
	private String society;
	@Column(length = 50)
	private String landmark;
	@Column(length = 75)
	private String area;

	@OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
	private List<PropertyReview> reviewList = new ArrayList<PropertyReview>();

	@OneToMany(mappedBy = "propertyId", cascade = CascadeType.ALL)
	private List<PropertyImage> imageList = new ArrayList<>();

	@OneToOne(mappedBy = "propertyId", cascade = CascadeType.ALL)
	private PropertyBooking propertyBooking;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

	public Property() {

	}

	public User getUser() {
		return user;
	}

	public List<PropertyReview> getReviewList() {
		return reviewList;
	}

	public void setReviewList(List<PropertyReview> reviewList) {
		this.reviewList = reviewList;
	}

	public List<PropertyImage> getImageList() {
		return imageList;
	}

	public void setImageList(List<PropertyImage> imageList) {
		this.imageList = imageList;
	}

	public PropertyBooking getPropertyBooking() {
		return propertyBooking;
	}

	public void setPropertyBooking(PropertyBooking propertyBooking) {
		this.propertyBooking = propertyBooking;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public FlatCategory getCategory() {
		return category;
	}

	public void setCategory(FlatCategory category) {
		this.category = category;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getRent() {
		return rent;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}

	public String getSociety() {
		return society;
	}

	public void setSociety(String society) {
		this.society = society;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	// helper methods to map category fields with dto
	public String getCategoryName() {
		return category.getCategoryName();
	}

	public String getDescription() {
		return category.getDescription();
	}

	// method to map userId
	public long getUserId() {
		return user.getId();
	}

	// helper methods to map city fields with dto
	public String getCityName() {
		return city.getCityName();
	}

	public String getState() {
		return city.getState();
	}

	public int getPincode() {
		return city.getPincode();
	}

	// helper method to map property id
	public Long getPropertyId() {
		return getId();
	}

	@Override
	public String toString() {
		return "Property [user=" + user + ", category=" + category + ", instructions=" + instructions + ", isAvailable="
				+ isAvailable + ", deposit=" + deposit + ", rent=" + rent + ", society=" + society + ", landmark="
				+ landmark + ", area=" + area + ", city=" + city + "]";
	}

}

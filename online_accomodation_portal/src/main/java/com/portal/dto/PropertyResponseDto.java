package com.portal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class PropertyResponseDto {
	
	@JsonProperty(access = Access.READ_WRITE)
	private Long userId ;
	
	@JsonProperty(access = Access.READ_WRITE)
	private Long propertyId;
	 
	@JsonProperty(access = Access.READ_WRITE)
	private String categoryName;
	@JsonProperty(access = Access.READ_WRITE)
	private String description;
	@JsonProperty(access = Access.READ_WRITE)
	private String instructions;
	@JsonProperty(access = Access.READ_WRITE)
	private int deposit;
	@JsonProperty(access = Access.READ_WRITE)
	private int rent;
	@JsonProperty(access = Access.READ_WRITE)	
	private String society;
	@JsonProperty(access = Access.READ_WRITE)
	private String landmark;
	@JsonProperty(access = Access.READ_WRITE)
	private String area;
	@JsonProperty(access = Access.READ_WRITE)
	private String cityName;
	@JsonProperty(access = Access.READ_WRITE)
	private String  state;
	@JsonProperty(access = Access.READ_WRITE)
	private int pincode;

	
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
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

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	

	public Long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}

	@Override
	public String toString() {
		return "PropertyResponseDto [userId=" + userId + ", categoryName=" + categoryName + ", description="
				+ description + ", instructions=" + instructions + ", deposit=" + deposit + ", rent=" + rent
				+ ", society=" + society + ", landmark=" + landmark + ", area=" + area + ", cityName=" + cityName
				+ ", state=" + state + ", pincode=" + pincode + "]";
	}
	
	
	

}

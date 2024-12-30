package com.portal.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class AddPropertyDto {

	@NotBlank
	@JsonProperty(access = Access.WRITE_ONLY)
	private Long userId;

	@NotBlank(message = "Provide Instructions")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String instructions;

	@JsonProperty(access = Access.WRITE_ONLY)
	private int isAvailable = 1;

	@NotBlank(message = "Deposit Required")
	@JsonProperty(access = Access.WRITE_ONLY)
	private int deposit;

	@NotBlank
	@JsonProperty(access = Access.WRITE_ONLY)
	private int rent;

	@JsonProperty(access = Access.WRITE_ONLY)
	private String society;

	@JsonProperty(access = Access.WRITE_ONLY)
	private String landmark;

	@JsonProperty(access = Access.WRITE_ONLY)
	private String area;

	@JsonProperty(access = Access.WRITE_ONLY)
	private String cityName;

	@JsonProperty(access = Access.WRITE_ONLY)
	private String state;

	@JsonProperty(access = Access.WRITE_ONLY)
	private Long pincode;
	@NotBlank(message = "Category Required")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String categoryName;

	@NotBlank(message = "Please Provide Description")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String description;

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

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public int getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(int isAvailable) {
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

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String city) {
		this.cityName = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getPincode() {
		return pincode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "AddPropertyDto [userId=" + userId + ", categoryName=" + categoryName + ", description=" + description
				+ ", instructions=" + instructions + ", isAvailable=" + isAvailable + ", deposit=" + deposit + ", rent="
				+ rent + ", society=" + society + ", landmark=" + landmark + ", area=" + area + ", cityName=" + cityName
				+ ", state=" + state + ", pincode=" + pincode + "]";
	}

}

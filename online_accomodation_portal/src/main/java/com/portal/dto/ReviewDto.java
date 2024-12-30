package com.portal.dto;

import javax.persistence.AccessType;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {

//	@JsonProperty(access = Access.READ_WRITE)
//	// used during serialization
//	private Long propertyId ;

	@NotBlank
	@JsonProperty(access = Access.READ_WRITE)
	private float rating;

	@NotBlank
	@JsonProperty(access = Access.READ_WRITE)
	private String comment;

	@NotBlank
	private Long userId;

//	public Long getPropertyId() {
//
//		return propertyId;
//	}
//
//	public void setPropertyId(Long propertyId) {
//		this.propertyId = propertyId;
//	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "ReviewDto [ rating=" + rating + ", comment=" + comment + ", userId=" + userId + "]";
	}

}

package com.portal.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

@Table(name = "property_reviews")
@NoArgsConstructor
@Entity
public class PropertyReview extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "property_id")
	private Property property;

	@Column
	private float rating;

	@Column(length = 250)
	private String comment;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}

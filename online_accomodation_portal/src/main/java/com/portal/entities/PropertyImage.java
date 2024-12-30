package com.portal.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "property_image")
public class PropertyImage extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "property_id")
	private Property propertyId;

	@Column(name = "image_path")
	private String imagePath;

	public PropertyImage() {

	}

	public Property getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Property propertyId) {
		this.propertyId = propertyId;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}

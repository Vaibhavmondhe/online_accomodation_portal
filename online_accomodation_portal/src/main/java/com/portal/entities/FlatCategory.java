package com.portal.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.action.internal.OrphanRemovalAction;
import org.hibernate.type.TrueFalseType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="flat_category")
@Getter
@Setter
@ToString
public class FlatCategory extends BaseEntity {
	
	@Column
	private String categoryName;
	
	@Column(length =50)
	private String description;
	
	

	public FlatCategory() {

		// TODO Auto-generated constructor stub
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




	@Override
	public String toString() {
		return "FlatCategory [categoryName=" + categoryName + ", description=" + description + "]";
	}
	
	
	
	
	
}

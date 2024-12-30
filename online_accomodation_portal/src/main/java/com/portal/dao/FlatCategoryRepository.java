package com.portal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.entities.FlatCategory;

public interface FlatCategoryRepository  extends JpaRepository<FlatCategory, Long>{

	FlatCategory findByCategoryNameAndDescription(String categoryName, String description);
	
	
}

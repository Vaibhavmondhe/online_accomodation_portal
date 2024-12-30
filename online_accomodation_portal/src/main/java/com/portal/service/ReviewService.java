package com.portal.service;

import java.util.List;

import com.portal.dto.ReviewDto;
import com.portal.dto.PropertyReviewRespDTO;
import com.portal.dto.UpdateReviewDTO;

public interface ReviewService {

	String addReview(ReviewDto dto, Long propertyId);

	List<PropertyReviewRespDTO> fetchAllReviews(Long propertyId);

	String deleteReview(Long reviewId);

	String updateReview(UpdateReviewDTO dto);

	List<PropertyReviewRespDTO> showAllReviewsByUser(Long userId);
}

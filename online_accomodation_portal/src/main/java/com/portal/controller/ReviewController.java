package com.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.portal.dto.ReviewDto;
import com.portal.dto.PropertyReviewRespDTO;
import com.portal.dto.UpdateReviewDTO;
import com.portal.service.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@PostMapping("/add")
	public ResponseEntity<?> addReview(@RequestBody ReviewDto dto, @RequestParam Long propertyId) {

		System.out.println(dto.toString());

		return ResponseEntity.status(HttpStatus.OK).body(reviewService.addReview(dto, propertyId));

	}

	// incomplete method
	// get reviews by property id
	// http:/localhost:8080/reviews/{propertyId}
	@GetMapping("/property")
	public List<PropertyReviewRespDTO> showAllReviewsByProperty(@RequestParam Long propertyId) {
		System.out.println("hiii" + propertyId);
		return reviewService.fetchAllReviews(propertyId);
	}

	// http:/localhost:8080/reviews/{userId}
	@GetMapping("/user/{userId}")
	public List<PropertyReviewRespDTO> showAllReviewsByUser(@PathVariable Long userId) {
		return reviewService.showAllReviewsByUser(userId);
	}

	// delete review
	// http:/localhost:8080/reviews/delete/{reviewId}
	@DeleteMapping("/delete/{reviewId}")
	public ResponseEntity<?> deleteReview(@PathVariable Long reviewId) {
		return ResponseEntity.status(HttpStatus.OK).body(reviewService.deleteReview(reviewId));
	}

	// delete review
	// http:/localhost:8080/reviews/update
	@PutMapping("/update")
	public ResponseEntity<?> updateReview(@RequestBody UpdateReviewDTO dto) {
		return ResponseEntity.status(HttpStatus.OK).body(reviewService.updateReview(dto));
	}

}

package com.portal.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.dao.PropertyRepository;
import com.portal.dao.ReviewRepository;
import com.portal.dao.UserDao;
import com.portal.dto.ReviewDto;
import com.portal.dto.PropertyReviewRespDTO;
import com.portal.dto.UpdateReviewDTO;
import com.portal.entities.Property;
import com.portal.entities.PropertyReview;
import com.portal.entities.User;
import com.portal.exception.CustomException;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository reviewRepo;

	@Autowired
	private ModelMapper mapper;
	@Autowired
	private PropertyRepository propertyRepo;

	@Autowired
	private UserDao userDao;

	@Override
	public String addReview(ReviewDto dto, Long propertyId) {

		System.out.println(dto.toString());
		Property property = propertyRepo.findById(propertyId)
				.orElseThrow(() -> new CustomException("Property Not Found"));
		User user = userDao.findById(dto.getUserId()).orElseThrow(() -> new CustomException("user not found"));
		PropertyReview review = mapper.map(dto, PropertyReview.class);
		review.setProperty(property);
		review.setUser(user);
		reviewRepo.save(review);
		return "Review  Added Successfully";
	}

	// incomplete
	@Override
	public List<PropertyReviewRespDTO> fetchAllReviews(Long propertyId) {
		System.out.println("hiii" + propertyId);
		List<PropertyReviewRespDTO> responseList = new ArrayList<PropertyReviewRespDTO>();
		if (propertyRepo.existsById(propertyId)) {
			Property property = propertyRepo.findById(propertyId)
					.orElseThrow(() -> new CustomException("property not found"));

			List<PropertyReview> propertyReviewList = reviewRepo.findByPropertyAndUserIsNotNull(property);

			for (PropertyReview propertyReview : propertyReviewList) {
				// Access userName from the associated User entity
				String firstName = propertyReview.getUser().getFirstName();
				String lastName = propertyReview.getUser().getLastName();
				PropertyReviewRespDTO p = new PropertyReviewRespDTO();
				p.setFirstName(firstName);
				p.setLastName(lastName);
				p.setRating(propertyReview.getRating());
				p.setComment(propertyReview.getComment());
				p.setId(propertyReview.getId());
				responseList.add(p);
			}

			// responseList = Arrays.asList(mapper.map(propertyReviewList,
			// PropertyReviewRespDTO[].class));
		}
		return responseList;
	}

	@Override
	public List<PropertyReviewRespDTO> showAllReviewsByUser(Long userId) {

		List<PropertyReviewRespDTO> responseList = new ArrayList<PropertyReviewRespDTO>();
		if (userDao.existsById(userId)) {
			User user = userDao.findById(userId).orElseThrow(() -> new CustomException("user not found"));

			List<PropertyReview> propertyReviewList = reviewRepo.findByUser(user);

			responseList = Arrays.asList(mapper.map(propertyReviewList, PropertyReviewRespDTO[].class));
		}
		return responseList;
	}

	@Override
	public String deleteReview(Long reviewId) {
		// TODO Auto-generated method stub
		if (reviewRepo.existsById(reviewId)) {
			reviewRepo.deleteById(reviewId);
			return "Review Deleted Successfully";
		} else {
			return "ReviewId Is Invalid";

		}
	}

	@Override
	public String updateReview(UpdateReviewDTO dto) {
		// TODO Auto-generated method stub
		PropertyReview propertyReview = reviewRepo.findById(dto.getReviewId())
				.orElseThrow(() -> new CustomException("Property Not Found"));
		// propertyReview = mapper.map(dto, PropertyReview.class);

		propertyReview.setComment(dto.getComment());
		propertyReview.setRating(dto.getRating());
		reviewRepo.save(propertyReview);
		return "Review updated Successfully";
	}

}

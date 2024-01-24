package com.deuscodex.app.service;

import com.deuscodex.app.dto.ReviewDTO;

import java.util.List;

public interface ReviewService {

    ReviewDTO getReviewById(Long reviewId);

    List<ReviewDTO> getAllReviews();

    ReviewDTO createReview(ReviewDTO reviewDTO);

    ReviewDTO updateReview(Long reviewId, ReviewDTO reviewDTO);

    boolean deleteReview(Long reviewId);
}

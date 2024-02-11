package com.deuscodex.app.mapper;

import com.deuscodex.app.domain.Review;
import com.deuscodex.app.dto.ReviewDTO;

public class ReviewMapper {

    private ReviewMapper() {
        // 인스턴스 생성 방지
    }

    public static ReviewDTO toDTO(Review review) {
        return ReviewDTO.builder()
                .reviewId(review.getId())
                .restaurantId(review.getRestaurant().getId())
                .userId(review.getUserId())
                .rating(review.getRating())
                .reviewContent(review.getReviewContent())
                .createdAt(review.getCreatedAt())
                .build();
    }

    public static Review toEntity(ReviewDTO reviewDTO) {
        return Review.builder()
                .id(reviewDTO.getReviewId())
                .userId(reviewDTO.getUserId())
                .rating(reviewDTO.getRating())
                .reviewContent(reviewDTO.getReviewContent())
                .createdAt(reviewDTO.getCreatedAt())
                .build();
    }
}

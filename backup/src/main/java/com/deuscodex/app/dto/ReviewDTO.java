package com.deuscodex.app.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewDTO {

    private Long reviewId;

    private Long restaurantId;

    private Long userId;

    private int rating;

    @NotBlank(message = "Review content cannot be blank")
    private String reviewContent;

    private LocalDateTime createdAt;

    // Getters and Setters
}

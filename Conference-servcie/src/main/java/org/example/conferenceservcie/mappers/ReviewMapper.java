package org.example.conferenceservcie.mappers;

import org.example.conferenceservcie.DTOs.ReviewDTO;
import org.example.conferenceservcie.entities.Review;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface ReviewMapper {
    ReviewDTO toReviewDTO(Review review);
    Review toReview(ReviewDTO reviewDTO);
}

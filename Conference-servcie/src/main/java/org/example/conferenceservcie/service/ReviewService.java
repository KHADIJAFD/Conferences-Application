package org.example.conferenceservcie.service;

import org.example.conferenceservcie.DTOs.ReviewDTO;
import org.example.conferenceservcie.exceptions.ReviewNotFoundException;

import java.util.List;

public interface ReviewService {
    List<ReviewDTO> getReviews();
    ReviewDTO getReviewById(long id) throws ReviewNotFoundException;
    void deleteReview(long id) throws ReviewNotFoundException;
}

package org.example.conferenceservcie.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.conferenceservcie.DTOs.ReviewDTO;
import org.example.conferenceservcie.entities.Review;
import org.example.conferenceservcie.exceptions.ReviewNotFoundException;
import org.example.conferenceservcie.feign.KeynoteRestClient;
import org.example.conferenceservcie.mappers.ReviewMapper;
import org.example.conferenceservcie.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
@Slf4j
public class ReviewServiceImpl implements ReviewService{
    private ReviewRepository reviewRepository;
    private ReviewMapper reviewMapper;
    private final KeynoteRestClient keynoteRestClient;
    @Override
    public List<ReviewDTO> getReviews() {
        List<ReviewDTO> reviewDTOS = reviewRepository
                .findAll().stream()
                .map(reviewMapper::toReviewDTO)
                .toList();
        return reviewDTOS;
    }

    @Override
    public ReviewDTO getReviewById(long id) throws ReviewNotFoundException {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new ReviewNotFoundException("Transfer with ID " + id + " not found"));
        return reviewMapper.toReviewDTO(review);
    }

    @Override
    public void deleteReview(long id) throws ReviewNotFoundException {
        log.info("deleting transfer with id: {}", id);
        if (!reviewRepository.existsById(id)) throw new ReviewNotFoundException("Review with ID " + id + " not found");
        reviewRepository.deleteById(id);
    }
}

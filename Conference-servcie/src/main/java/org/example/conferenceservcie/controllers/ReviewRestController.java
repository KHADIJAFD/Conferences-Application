package org.example.conferenceservcie.controllers;

import lombok.AllArgsConstructor;
import org.example.conferenceservcie.DTOs.ReviewDTO;
import org.example.conferenceservcie.exceptions.ReviewNotFoundException;
import org.example.conferenceservcie.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RequestMapping("/api/reviews")
@RestController
public class ReviewRestController {
    private ReviewService reviewService;

    @GetMapping
    public List<ReviewDTO> getReviews() {
        return reviewService.getReviews();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable long id) throws ReviewNotFoundException {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewDTO> getTransferById(@PathVariable long id) throws ReviewNotFoundException {
        ReviewDTO reviewDTO = reviewService.getReviewById(id);
        return ResponseEntity.ok(reviewDTO);
    }
}

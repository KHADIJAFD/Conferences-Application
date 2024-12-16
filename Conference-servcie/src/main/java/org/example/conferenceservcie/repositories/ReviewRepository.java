package org.example.conferenceservcie.repositories;

import org.example.conferenceservcie.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}

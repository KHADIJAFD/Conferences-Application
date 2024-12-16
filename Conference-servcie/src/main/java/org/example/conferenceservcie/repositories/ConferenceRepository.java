package org.example.conferenceservcie.repositories;

import org.example.conferenceservcie.entities.Conference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceRepository extends JpaRepository<Conference,Long> {
}

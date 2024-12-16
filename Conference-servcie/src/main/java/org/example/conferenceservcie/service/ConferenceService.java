package org.example.conferenceservcie.service;

import org.example.conferenceservcie.DTOs.ConferenceDTO;
import org.example.conferenceservcie.exceptions.ConferenceNotFoundException;

import java.util.List;

public interface ConferenceService {
    List<ConferenceDTO> getConferences();
    ConferenceDTO getConferenceById(long id) throws ConferenceNotFoundException;
    void deleteConference(long id) throws ConferenceNotFoundException;
}

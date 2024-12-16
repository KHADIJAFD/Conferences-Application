package org.example.conferenceservcie.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.conferenceservcie.DTOs.ConferenceDTO;
import org.example.conferenceservcie.entities.Conference;
import org.example.conferenceservcie.exceptions.ConferenceNotFoundException;
import org.example.conferenceservcie.feign.KeynoteRestClient;
import org.example.conferenceservcie.mappers.ConferenceMapper;
import org.example.conferenceservcie.repositories.ConferenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
@Slf4j
public class ConferenceServiceImpl implements ConferenceService{
    private ConferenceRepository conferenceRepository;
    private ConferenceMapper conferenceMapper;
    private final KeynoteRestClient keynoteRestClient;
    @Override
    public List<ConferenceDTO> getConferences() {
        List<ConferenceDTO> conferenceDTOS = conferenceRepository
                .findAll().stream()
                .map(conferenceMapper::toConferenceDTO)
                .toList();
        return conferenceDTOS;
    }

    @Override
    public ConferenceDTO getConferenceById(long id) throws ConferenceNotFoundException {
        Conference conference = conferenceRepository.findById(id)
                .orElseThrow(() -> new ConferenceNotFoundException("Transfer with ID " + id + " not found"));
        return conferenceMapper.toConferenceDTO(conference);
    }

    @Override
    public void deleteConference(long id) throws ConferenceNotFoundException {
        log.info("deleting transfer with id: {}", id);
        if (!conferenceRepository.existsById(id)) throw new ConferenceNotFoundException("Transfer with ID " + id + " not found");
        conferenceRepository.deleteById(id);
    }
}

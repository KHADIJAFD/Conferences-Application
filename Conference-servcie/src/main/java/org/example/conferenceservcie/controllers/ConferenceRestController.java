package org.example.conferenceservcie.controllers;

import lombok.AllArgsConstructor;
import org.example.conferenceservcie.DTOs.ConferenceDTO;
import org.example.conferenceservcie.exceptions.ConferenceNotFoundException;
import org.example.conferenceservcie.service.ConferenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/api/conferences")
@RestController
public class ConferenceRestController {
    private ConferenceService conferenceService;

    @GetMapping
    public List<ConferenceDTO> getConferences() {
        return conferenceService.getConferences();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteConference(@PathVariable long id) throws ConferenceNotFoundException {
        conferenceService.deleteConference(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConferenceDTO> getTransferById(@PathVariable long id) throws ConferenceNotFoundException {
        ConferenceDTO conferenceDTO = conferenceService.getConferenceById(id);
        return ResponseEntity.ok(conferenceDTO);
    }
}

package org.example.conferenceservcie.mappers;

import org.example.conferenceservcie.DTOs.ConferenceDTO;
import org.example.conferenceservcie.entities.Conference;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface ConferenceMapper {
    ConferenceDTO toConferenceDTO(Conference conference);
    Conference toConference(ConferenceDTO conferenceDTO);
}

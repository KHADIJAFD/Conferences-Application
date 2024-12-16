package org.example.keynoteservice.mappers;

import org.example.keynoteservice.DTOs.KeynoteDTO;
import org.example.keynoteservice.entities.Keynote;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KeynoteMapper {
    KeynoteDTO toKeynoteDTO(Keynote keynote);
    Keynote toKeynote(KeynoteDTO keynoteDTO);
}

package org.example.keynoteservice.service;

import org.example.keynoteservice.DTOs.KeynoteDTO;
import org.example.keynoteservice.execptions.KeynoteNotFoundException;

import java.util.List;

public interface KeynoteService {
    List<KeynoteDTO> getKeynotes();
    KeynoteDTO getKeynoteById(long id) throws KeynoteNotFoundException;

    KeynoteDTO saveKeynote(KeynoteDTO keynoteDTO);

    void deleteKeynote(long id) throws KeynoteNotFoundException;}

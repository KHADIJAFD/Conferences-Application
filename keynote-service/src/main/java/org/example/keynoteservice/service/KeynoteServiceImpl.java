package org.example.keynoteservice.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.keynoteservice.DTOs.KeynoteDTO;
import org.example.keynoteservice.entities.Keynote;
import org.example.keynoteservice.execptions.KeynoteNotFoundException;
import org.example.keynoteservice.mappers.KeynoteMapper;
import org.example.keynoteservice.repositories.KeynoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class KeynoteServiceImpl implements KeynoteService{
    private KeynoteMapper keynoteMapper;
    private KeynoteRepository keynoteRepository;


    @Override
    public List<KeynoteDTO> getKeynotes() {
        return keynoteRepository.findAll()
                .stream()
                .map(keynoteMapper::toKeynoteDTO)
                .toList();
    }

    @Override
    public KeynoteDTO getKeynoteById(long id) throws KeynoteNotFoundException {
        return keynoteMapper.toKeynoteDTO(keynoteRepository.findById(id).orElseThrow(() -> new KeynoteNotFoundException("Keynote with ID " + id + " not found")));
    }

    @Override
    public KeynoteDTO saveKeynote(KeynoteDTO keynoteDTO) {
        Keynote keynote = keynoteMapper.toKeynote(keynoteDTO);
        return keynoteMapper.toKeynoteDTO(keynoteRepository.save(keynote));
    }


    @Override
    public void deleteKeynote(long id) throws KeynoteNotFoundException {
        log.info("deleting Keynote with id: {}", id);
        if(!keynoteRepository.existsById(id)) throw new KeynoteNotFoundException("Keynote not found");
        keynoteRepository.deleteById(id);
    }
}

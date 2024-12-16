package org.example.conferenceservcie.DTOs;

import lombok.Data;
import org.example.conferenceservcie.enums.ConferenceType;

import java.util.Date;
@Data
public class ConferenceDTO {
    private Long id;
    private String titre;
    private Date date;
    private double duree;
    private int nombreInscrits;
    private double score;
    private ConferenceType status;
}

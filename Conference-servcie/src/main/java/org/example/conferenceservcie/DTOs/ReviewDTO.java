package org.example.conferenceservcie.DTOs;

import lombok.Data;

import java.util.Date;
@Data
public class ReviewDTO {
    private Long id;
    private Date date;
    private String text;
    private int note;
}

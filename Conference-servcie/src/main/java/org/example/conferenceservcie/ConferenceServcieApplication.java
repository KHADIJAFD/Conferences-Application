package org.example.conferenceservcie;

import org.example.conferenceservcie.entities.Conference;
import org.example.conferenceservcie.entities.Review;
import org.example.conferenceservcie.enums.ConferenceType;
import org.example.conferenceservcie.repositories.ConferenceRepository;
import org.example.conferenceservcie.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class ConferenceServcieApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConferenceServcieApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ConferenceRepository conferenceRepository, ReviewRepository reviewRepository){
        return args -> {
            //creation des conferences:
            Conference conference1 = new Conference();
            conference1.setTitre("Data integration");
            conference1.setDate(new Date());
            conference1.setDuree(4);
            conference1.setNombreInscrits(80);
            conference1.setScore(4.5);
            conference1.setStatus(ConferenceType.ACADEMIQUE);
            conferenceRepository.save(conference1);

            Conference conference2 = new Conference();
            conference2.setTitre("E-commerce");
            conference2.setDate(new Date());
            conference2.setDuree(3.0);
            conference2.setNombreInscrits(300);
            conference2.setScore(3.9);
            conference2.setStatus(ConferenceType.COMMERCIALE);
            conferenceRepository.save(conference2);

            // creations des review pour conf1
            Review review1 = new Review();
            review1.setDate(new Date());
            review1.setText("Amazing initiation to data integration");
            review1.setNote(5);
            review1.setConference(conference1);
            reviewRepository.save(review1);

            Review review2 = new Review();
            review2.setDate(new Date());
            review2.setText("Very informative,I explored new technologies");
            review2.setNote(4);
            review2.setConference(conference1);
            reviewRepository.save(review2);

            // creation des reviews pour conf2
            Review review3 = new Review();
            review3.setDate(new Date());
            review3.setText("Exceptional content!!");
            review3.setNote(5);
            review3.setConference(conference2);
            reviewRepository.save(review3);
        };
    }
}

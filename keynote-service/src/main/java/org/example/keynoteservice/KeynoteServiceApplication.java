package org.example.keynoteservice;

import org.example.keynoteservice.entities.Keynote;
import org.example.keynoteservice.repositories.KeynoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class KeynoteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeynoteServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(KeynoteRepository keynoteRepository) {
		return args -> {
			List.of("Khadija", "Zineb", "Hamza", "Imane").forEach(name -> {
				keynoteRepository.save(Keynote.builder().
						nom(name).
						prenom(name).
						fonction("Speaker").
						email(name + "@gmail.com").build());
			});
		};
	}
}

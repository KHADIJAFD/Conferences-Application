package org.example.keynoteservice.repositories;

import org.example.keynoteservice.entities.Keynote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)

public interface KeynoteRepository extends JpaRepository<Keynote,Long> {
}

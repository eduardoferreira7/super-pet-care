package br.com.superpetcare.superpetcare.repository;

import br.com.superpetcare.superpetcare.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PetRepository extends JpaRepository<Pet, UUID> {
    List<Pet> findByServiceDescriptionIgnoreCase(String serviceDescription);
    List<Pet> findByBreedNameIgnoreCase(String breedName);
}


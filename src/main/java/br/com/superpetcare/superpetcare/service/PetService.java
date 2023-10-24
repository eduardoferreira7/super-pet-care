package br.com.superpetcare.superpetcare.service;

import br.com.superpetcare.superpetcare.controller.exception.ControlerNotFoundException;
import br.com.superpetcare.superpetcare.dto.PetDTO;
import br.com.superpetcare.superpetcare.entities.Pet;
import br.com.superpetcare.superpetcare.repository.PetRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public Collection<PetDTO> findAll() {
        var pets = petRepository.findAll();
        return pets.stream().map(this::toPetDTO).collect(Collectors.toList());
    }

    public PetDTO findById(UUID id) {
        var pet = petRepository.findById(id).orElseThrow(() -> new ControlerNotFoundException("Pet não encontrado"));
        return toPetDTO(pet);
    }

    public PetDTO save(PetDTO petDTO) {
        Pet pet = toPet(petDTO);
        pet = petRepository.save(pet);
        return toPetDTO(pet);
    }

    public PetDTO update(UUID id, PetDTO petDTO) {
        try {
            Pet searchPet = petRepository.getReferenceById(id);
            searchPet.setName(petDTO.name());
            searchPet.setDescription(petDTO.description());
            searchPet.setImageUrl(petDTO.imageUrl());
            searchPet.setServiceValue(petDTO.serviceValue());
            searchPet = petRepository.save(searchPet);

            return toPetDTO(searchPet);

        } catch (EntityNotFoundException e) {
            throw new ControlerNotFoundException("Pet não encontrado");
        }
    }

    public void delete(UUID id) {
        petRepository.deleteById(id);
    }

    private PetDTO toPetDTO(Pet pet) {
        return new PetDTO(
                pet.getId(),
                pet.getName(),
                pet.getDescription(),
                pet.getImageUrl(),
                pet.getServiceValue()
        );
    }

    private Pet toPet(PetDTO petDTO){
        return new Pet(
                petDTO.id(),
                petDTO.name(),
                petDTO.description(),
                petDTO.imageUrl(),
                petDTO.serviceValue()
        );
    }
}

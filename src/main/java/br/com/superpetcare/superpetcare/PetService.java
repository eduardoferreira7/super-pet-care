package br.com.superpetcare.superpetcare;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public Collection<Pet> findAll(){
        var pets = petRepository.findAll();
        return pets;
    }

    public Pet findById(UUID id){
        var pet = petRepository.findById(id).orElseThrow(() -> new ControlerNotFoundException("Pet não encontrado"));
        return pet;
    }

    public Pet save(Pet pet){
        pet = petRepository.save(pet);

        return pet;
    }

    public Pet update(UUID id, Pet pet){
        Pet searchPet = petRepository.getOne(id);

        try {
            searchPet.setName(pet.getName());
            searchPet.setDescription(pet.getDescription());
            searchPet.setImageUrl(pet.getImageUrl());
            searchPet = petRepository.save(searchPet);

            return searchPet;

        } catch (EntityNotFoundException e){
            throw new ControlerNotFoundException("Produto não encontrado");
        }

    }

    public void delete(UUID id){
        petRepository.deleteById(id);
    }

}

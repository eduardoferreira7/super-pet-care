package br.com.superpetcare.superpetcare;

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

    public Optional<Pet> findById(UUID id){
        var pet = petRepository.findById(id);
        return pet;
    }

    public Pet save(Pet pet){
        pet = petRepository.save(pet);

        return pet;
    }

    public Pet update(UUID id, Pet pet){
        Pet searchPet = petRepository.getOne(id);

        searchPet.setName(pet.getName());
        searchPet.setDescription(pet.getDescription());
        searchPet.setImageUrl(pet.getImageUrl());
        searchPet = petRepository.save(searchPet);

        return searchPet;
    }

    public void delete(UUID id){
        petRepository.deleteById(id);
    }

}

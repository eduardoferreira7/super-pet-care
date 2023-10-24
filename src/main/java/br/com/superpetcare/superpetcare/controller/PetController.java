package br.com.superpetcare.superpetcare.controller;

import br.com.superpetcare.superpetcare.dto.PetDTO;
import br.com.superpetcare.superpetcare.entities.Pet;
import br.com.superpetcare.superpetcare.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public ResponseEntity<Collection<PetDTO>> findAll() {
        var pets = petService.findAll();

        return ResponseEntity.ok(pets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetDTO> findById(@PathVariable UUID id){
        var pet = petService.findById(id);

        return ResponseEntity.ok(pet);
    }

    @PostMapping
    public ResponseEntity<PetDTO> save(@RequestBody PetDTO petDTO){
        petDTO = petService.save(petDTO);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(petDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetDTO> update(
            @PathVariable UUID id, @RequestBody PetDTO petDTO)
    {
        petDTO = petService.update(id, petDTO);
        return ResponseEntity.ok(petDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        petService.delete(id);

        return ResponseEntity.noContent().build();
    }
}

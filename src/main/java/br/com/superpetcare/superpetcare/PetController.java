package br.com.superpetcare.superpetcare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public ResponseEntity<Collection<Pet>> findAll() {
        var pets = petService.findAll();

        return ResponseEntity.ok(pets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pet>> findById(@PathVariable UUID id){
        var pet = petService.findById(id);

        return ResponseEntity.ok(pet);
    }

    @PostMapping
    public ResponseEntity<Pet> save(@RequestBody Pet pet){
        pet = petService.save(pet);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(pet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet> update(
            @PathVariable UUID id, @RequestBody Pet pet)
    {
        pet = petService.update(id, pet);
        return ResponseEntity.ok(pet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        petService.delete(id);

        return ResponseEntity.noContent().build();
    }
}

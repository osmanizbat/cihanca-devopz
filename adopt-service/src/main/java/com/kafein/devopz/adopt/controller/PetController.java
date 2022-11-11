package com.kafein.devopz.adopt.controller;

import com.kafein.devopz.adopt.model.Pet;
import com.kafein.devopz.adopt.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;

    @PostMapping("/save")
    public ResponseEntity<Pet> save(@RequestBody Pet pet) {
        Pet response = petService.save(pet);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Pet>> list() {
        return ResponseEntity.ok(petService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> findById(@PathVariable int id) {
        return ResponseEntity.ok(petService.findById(id));
    }

}

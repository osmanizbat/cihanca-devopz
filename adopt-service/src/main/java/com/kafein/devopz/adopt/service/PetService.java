package com.kafein.devopz.adopt.service;

import com.kafein.devopz.adopt.model.Pet;
import com.kafein.devopz.adopt.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;

    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    public List<Pet> list() {
        return petRepository.findAll();
    }

    public Pet findById(int id) {
        return petRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}

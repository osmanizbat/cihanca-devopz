package com.kafein.devopz.adopt.service;

import com.kafein.devopz.adopt.model.Adopt;
import com.kafein.devopz.adopt.repository.AdoptRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdoptService {

    private final AdoptRepository adoptRepository;


    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");


    public Adopt save(Adopt adopt) {
        adopt.setAdoptedDate(formatter.format(new Date()));
        adopt.setActive(true);
        return adoptRepository.save(adopt);
    }

    public Boolean cancel(int id) {
        Adopt adopt = adoptRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        adopt.setCancelDate(formatter.format(new Date()));
        adopt.setActive(false);
        adoptRepository.save(adopt);
        return true;
    }

    public List<Adopt> list() {
        return adoptRepository.findAll();
    }
}

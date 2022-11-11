package com.kafein.devopz.adopt.controller;

import com.kafein.devopz.adopt.model.Adopt;
import com.kafein.devopz.adopt.service.AdoptService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/main")
@RequiredArgsConstructor
public class AdoptController {

    private final AdoptService adoptService;

    @PostMapping("/adopt")
    public ResponseEntity<Adopt> save(@RequestBody Adopt adopt) {
        Adopt response = adoptService.save(adopt);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/cancel/{id}")
    public ResponseEntity<Boolean> cancel(@PathVariable int id) {
        return ResponseEntity.ok(adoptService.cancel(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Adopt>> list() {
        return ResponseEntity.ok(adoptService.list());
    }

}

package com.kafein.devopz.adopt.model;

import com.kafein.devopz.adopt.enums.PetType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Pet {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    private String tag;

    private String name;

    private PetType petType;

}

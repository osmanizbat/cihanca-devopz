package com.kafein.devopz.adopt.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Adopt {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @ManyToOne
    private Pet pet;

    private int adopterId;

    private String adoptedDate;

    private String cancelDate;

    private boolean active;

}

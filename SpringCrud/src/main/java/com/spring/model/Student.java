package com.spring.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "jazim")

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column
    private String name;

    @Column
    private String email;

}

package com.spring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "jazim")

public class Student {

    @Id
    private int id;
    @Column(name = "marks")
    private int mark;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String designation;

    @Column
    private int salary;

    @Column
    private String place;
}
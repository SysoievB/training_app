package com.training_app.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "programs")
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "length")
    private String length;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ProgramsStatus status;
}

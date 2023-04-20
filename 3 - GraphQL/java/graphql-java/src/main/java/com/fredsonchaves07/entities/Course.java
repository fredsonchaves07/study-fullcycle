package com.fredsonchaves07.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    private String description;

    @ManyToOne
    public Category category;

    public Course(String name, String description, Category category) {
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public Course() {

    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }
}

package com.fredsonchaves07.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;


    private String description;

    @OneToMany
    private List<Course> courses = new ArrayList<>();

    public Category() {}

    public Category(String name, String description, Course course) {
        this.name = name;
        this.description = description;
        this.courses.add(course);
    }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
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

    public List<Course> getCourses() {
        return courses;
    }
}

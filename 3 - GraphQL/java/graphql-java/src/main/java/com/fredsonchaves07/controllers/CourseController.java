package com.fredsonchaves07.controllers;

import com.fredsonchaves07.entities.Category;
import com.fredsonchaves07.entities.Course;
import com.fredsonchaves07.repositories.CategoryRepository;
import com.fredsonchaves07.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @MutationMapping
    public Course createCourse(@Argument NewCourse course) {
        Category category = categoryRepository.findById(UUID.fromString(course.categoryId)).orElseThrow();
        return courseRepository.save(new Course(course.name, course.description, category));
    }

    @QueryMapping
    public Course course(@Argument UUID id) {
        return courseRepository.findById(id).orElseThrow();
    }

    public record NewCourse(String name, String description, String categoryId){}
}

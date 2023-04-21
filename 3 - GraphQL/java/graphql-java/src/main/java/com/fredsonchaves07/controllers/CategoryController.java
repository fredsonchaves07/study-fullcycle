package com.fredsonchaves07.controllers;

import com.fredsonchaves07.entities.Category;
import com.fredsonchaves07.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @MutationMapping()
    public Category createCategory(@Argument NewCategory category) {
        return categoryRepository.save(new Category(category.name, category.description));
    }

    @QueryMapping()
    public List<Category> categories() {
        return categoryRepository.findAll();
    }

    public record NewCategory(String name, String description){}
}

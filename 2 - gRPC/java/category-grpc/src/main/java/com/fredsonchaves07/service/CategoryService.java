package com.fredsonchaves07.service;

import com.fredsonchaves07.CreateCategoryRequest;
import com.fredsonchaves07.entity.Category;
import com.fredsonchaves07.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService  {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public com.fredsonchaves07.Category create(CreateCategoryRequest categoryRequest) {
        String name = categoryRequest.getName();
        String description = categoryRequest.getDescription();
        Category category = categoryRepository.save(new Category(name, description));
        com.fredsonchaves07.Category categoryGrpc = com.fredsonchaves07.Category.newBuilder()
                .setId(category.getId().toString())
                .setName(category.getName())
                .setDescription(category.getDescription())
                .build();
        return categoryGrpc;
    }
}

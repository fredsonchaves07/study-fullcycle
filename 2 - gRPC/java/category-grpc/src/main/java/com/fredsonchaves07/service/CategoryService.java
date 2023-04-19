package com.fredsonchaves07.service;

import com.fredsonchaves07.CategoryList;
import com.fredsonchaves07.CreateCategoryRequest;
import com.fredsonchaves07.entity.Category;
import com.fredsonchaves07.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService  {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public com.fredsonchaves07.Category create(CreateCategoryRequest categoryRequest) {
        String name = categoryRequest.getName();
        String description = categoryRequest.getDescription();
        Category category = categoryRepository.save(new Category(name, description));
        return com.fredsonchaves07.Category.newBuilder()
                .setId(category.getId().toString())
                .setName(category.getName())
                .setDescription(category.getDescription())
                .build();
    }

    @Transactional
    public CategoryList create(List<CreateCategoryRequest> createCategoryGrpcList) {
        List<Category> categories = createCategoryGrpcList.stream()
                        .map(category -> new Category(
                                category.getName(), category.getDescription()
                        )).toList();
        categoryRepository.saveAll(categories);
        List<com.fredsonchaves07.Category> categoriesGrpc = categories.stream()
                .map(category -> com.fredsonchaves07.Category.newBuilder()
                        .setId(category.getId().toString())
                        .setName(category.getName())
                        .setDescription(category.getDescription())
                        .build()).toList();
        return CategoryList.newBuilder().addAllCategories(categoriesGrpc).build();
    }

    public CategoryList list() {
        List<Category> categories = categoryRepository.findAll();
        List<com.fredsonchaves07.Category> categoriesGrpc = categories.stream()
                .map(category -> com.fredsonchaves07.Category.newBuilder()
                        .setId(category.getId().toString())
                        .setName(category.getName())
                        .setDescription(category.getDescription())
                        .build()).toList();
        return CategoryList.newBuilder().addAllCategories(categoriesGrpc).build();
    }

    public com.fredsonchaves07.Category get(String id) {
        Category category = categoryRepository.findById(UUID.fromString(id)).get();
        return com.fredsonchaves07.Category.newBuilder()
                .setId(category.getId().toString())
                .setName(category.getName())
                .setDescription(category.getDescription())
                .build();
    }

}

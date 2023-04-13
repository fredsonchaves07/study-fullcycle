package com.fredsonchaves07.service;

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
    public Category create(String name, String description) {
        Category category = new Category(name, description);
        return categoryRepository.save(category);
    }
}

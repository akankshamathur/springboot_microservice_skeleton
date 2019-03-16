package com.example.services.impl;

import com.example.services.CategoryService;
import com.example.model.Category;
import com.example.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Category saveCategory(Category category) {
        categoryRepository.save(category);
        return category;
    }
}

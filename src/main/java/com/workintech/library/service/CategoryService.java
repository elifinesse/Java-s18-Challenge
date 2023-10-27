package com.workintech.library.service;

import java.util.List;

import com.workintech.library.entity.Category;

public interface CategoryService {
    List<Category> findAll();
    Category findById(long id);
    Category save(Category category);
    Category delete(long id);
}

package com.workintech.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workintech.library.dao.CategoryRepository;
import com.workintech.library.entity.Category;

@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(long id) {
        Optional<Category> found = categoryRepository.findById(id);
        if(found.isPresent()){
            return found.get();
        }
        return null;
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category delete(long id) {
        Category found = findById(id);
        categoryRepository.deleteById(id);
        return found;
    }
    
}

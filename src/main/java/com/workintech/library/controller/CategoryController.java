package com.workintech.library.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workintech.library.dto.CategoryResponse;
import com.workintech.library.entity.Category;
import com.workintech.library.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping("/")
    public CategoryResponse save(@RequestBody Category category){
        categoryService.save(category);
        return new CategoryResponse(category.getId(), category.getName());
    }

    @GetMapping("/")
    public List<CategoryResponse> findAll(){
        List<Category> categoryList = categoryService.findAll();
        List<CategoryResponse> responseList = new ArrayList<>();
        for(Category category: categoryList){
            responseList.add(new CategoryResponse(category.getId(), category.getName()));
        }
        return responseList;
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable long id){
        return categoryService.findById(id);
    }

    @DeleteMapping("/{id}")
    public Category delete(@PathVariable long id){
        return categoryService.delete(id);
    }
}

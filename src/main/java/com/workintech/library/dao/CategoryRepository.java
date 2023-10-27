package com.workintech.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workintech.library.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}

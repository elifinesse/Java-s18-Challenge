package com.workintech.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workintech.library.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{
    
}

package com.workintech.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workintech.library.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    
}

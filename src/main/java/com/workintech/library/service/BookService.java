package com.workintech.library.service;

import java.util.List;

import com.workintech.library.entity.Book;

public interface BookService {
    List<Book> findAll();
    Book findByBookId(long id);
    Book save(Book book);
    Book saveByCategoryId(long categoryId);
    Book saveByCategoryAndAuthorId(long categoryId, long authorId);
    Book deleteBook(long id);
}

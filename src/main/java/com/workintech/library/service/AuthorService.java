package com.workintech.library.service;

import java.util.List;

import com.workintech.library.entity.Author;

public interface AuthorService {
    List<Author> findAuthors();
    Author findByAuthorId(long id);
    Author save(Author author);
    Author saveBook(long bookId);
    Author deleteAuthor(long id);
}

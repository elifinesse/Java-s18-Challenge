package com.workintech.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.workintech.library.dao.AuthorRepository;
import com.workintech.library.entity.Author;

@Service
public class AuthorServiceImpl implements AuthorService{

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author findByAuthorId(long id) {
        Optional<Author> found = authorRepository.findById(id);
        if(found.isPresent()){
            return found.get();
        }
        return null;
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author deleteAuthor(long id) {
        Author found = findByAuthorId(id);
        authorRepository.deleteById(id);
        return found;
    }
    
}

package com.workintech.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workintech.library.dao.BookRepository;
import com.workintech.library.entity.Book;

@Service
public class BookServiceImpl implements BookService{

    private BookRepository bookRepository;


    @Autowired
    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findByBookId(long id) {
        Optional<Book> found = bookRepository.findById(id);
        if(found.isPresent()){
            return found.get();
        }
        return null;
    }

    @Override
    public Book saveByCategoryId(long categoryId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveByCategoryId'");
    }

    @Override
    public Book saveByCategoryAndAuthorId(long categoryId, long authorId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveByCategoryAndAuthorId'");
    }

    @Override
    public Book deleteBook(long id) {
        Book found = findByBookId(id);
        bookRepository.deleteById(id);
        return found;
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }
    
}

package com.workintech.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workintech.library.entity.Author;
import com.workintech.library.entity.Book;
import com.workintech.library.service.AuthorService;
import com.workintech.library.service.BookService;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private AuthorService authorService;
    private BookService bookService;

    @Autowired
    public AuthorController(AuthorService authorService, BookService bookService){
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @GetMapping("/")
    public List<Author> findAll(){
        return authorService.findAuthors();
    }

    @PostMapping("/")
    public Author save(@RequestBody Author author){
        return authorService.save(author);
    }

    @GetMapping("/{id}")
    public Author findById(@PathVariable long id){
        return authorService.findByAuthorId(id);
    }

    @DeleteMapping("/{id}")
    public Author delete(@PathVariable long id){
        return authorService.deleteAuthor(id);
    }

    @PostMapping("/{id}")
    public Author saveByBookId(@RequestBody Author author, @PathVariable long bookId){
        Book foundBook = bookService.findByBookId(bookId);
        author.addBook(foundBook);
        Author savedAuthor = new Author(author.getId(), author.getFirstName(), author.getLastName(), author.getAuthorBooks());
        return savedAuthor;
    }
}

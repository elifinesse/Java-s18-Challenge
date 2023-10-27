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

import com.workintech.library.dto.BookResponse;
import com.workintech.library.entity.Author;
import com.workintech.library.entity.Book;
import com.workintech.library.entity.Category;
import com.workintech.library.service.AuthorService;
import com.workintech.library.service.BookService;
import com.workintech.library.service.CategoryService;

@RestController
@RequestMapping("/book")
public class BookController {
    private BookService bookService;
    private CategoryService categoryService;
    private AuthorService authorService;

    @Autowired
    public BookController(BookService bookService, CategoryService categoryService, AuthorService authorService){
        this.bookService = bookService;
        this.categoryService = categoryService;
        this.authorService = authorService;
    }

    @GetMapping("/")
    public List<Book> findAll(){
        return bookService.findAll();
    }

    @PostMapping("/")
    public Book save(@RequestBody Book book){
        return bookService.save(book);
    }


    @PostMapping("/{id}")
    public BookResponse saveByCategory(@RequestBody Book book, @PathVariable long id){
        Category found = categoryService.findById(id);
        book.setCategory(found);
        found.addBook(book);
        bookService.save(book);
        return new BookResponse(book.getId(), book.getName(), found.getName(), null);
    }

    @PostMapping("/saveByAuthor/{categoryId}/{authorId}")
    public BookResponse saveByCategoryAndAuthor(@RequestBody Book book, @PathVariable long categoryId, @PathVariable long authorId){
        Category foundCategory = categoryService.findById(categoryId);
        Author foundAuthor = authorService.findByAuthorId(authorId);
        book.setAuthor(foundAuthor);
        book.setCategory(foundCategory);
        foundAuthor.addBook(book);
        foundCategory.addBook(book);
        bookService.save(book);
        return new BookResponse(book.getId(), book.getName(), foundCategory.getName(), foundAuthor.getFirstName() + " " + foundAuthor.getLastName());
    }

    @DeleteMapping("/{id}")
    public Book delete(@PathVariable long id){
        return bookService.deleteBook(id);
    }
}

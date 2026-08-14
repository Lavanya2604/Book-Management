package com.example.bookmanagement.controller;
import com.example.bookmanagement.entity.Book;
import com.example.bookmanagement.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // POST - Create Book
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {

        Book savedBook = bookService.createBook(book);

        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    // GET - Get All Books
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {

        List<Book> books = bookService.getAllBooks();

        return ResponseEntity.ok(books);
    }

    // GET - Get Book By ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {

        Book book = bookService.getBookById(id);

        return ResponseEntity.ok(book);
    }

    // DELETE - Delete Book By ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {

        bookService.deleteBook(id);

        return ResponseEntity.ok("Book deleted successfully");
    }
}
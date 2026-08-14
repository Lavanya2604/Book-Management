package com.example.bookmanagement.service;

import com.example.bookmanagement.entity.Book;
import com.example.bookmanagement.exception.BookNotFoundException;
import com.example.bookmanagement.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // POST - Create Book
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    // GET - Get All Books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // GET - Get Book By ID
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() ->
                        new BookNotFoundException(
                                "Book not found with id: " + id
                        ));
    }

    // DELETE - Delete Book By ID
    public void deleteBook(Long id) {

        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException(
                    "Book not found with id: " + id
            );
        }

        bookRepository.deleteById(id);
    }
}
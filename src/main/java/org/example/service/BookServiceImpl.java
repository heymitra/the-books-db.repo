package org.example.service;

import org.example.entity.Book;
import org.example.repository.BookRepository;
import org.example.util.ApplicationContext;

import java.sql.SQLException;


public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void addBook(String title, String publishYear, int authorId) throws SQLException {
        int bookId = bookRepository.save(new Book(title, publishYear, authorId));
        if (bookId == 0)
            System.out.println("There is no author with this author ID.");
        else
            System.out.println("Book added successfully.\nBook ID: " + bookId);
    }

    @Override
    public void load(int bookId) throws SQLException {
        Book result = bookRepository.load(bookId);
        if (result == null)
            System.out.println("There is no such book.");
        else {
            AuthorService authorService = ApplicationContext.getAuthorService();
            System.out.println(authorService.load(result.getAuthorId()));
            System.out.println(result);
        }
    }

    @Override
    public void delete(int bookId) throws SQLException {
        bookRepository.delete(bookId);
    }

    @Override
    public Book[] loadByAuthorId(int authorId) throws SQLException {
        return bookRepository.loadByAuthorId(authorId);
    }

}
package org.example.util;

import org.example.config.DatabaseConnector;
import org.example.repository.AuthorRepository;
import org.example.repository.AuthorRepositoryImpl;
import org.example.repository.BookRepository;
import org.example.repository.BookRepositoryImpl;
import org.example.service.AuthorService;
import org.example.service.AuthorServiceImpl;
import org.example.service.BookService;
import org.example.service.BookServiceImpl;

import java.sql.Connection;

public class ApplicationContext {

    private static Connection connection;
    private static AuthorRepository authorRepository;
    private static BookRepository bookRepository;
    private static AuthorService authorService;
    private static BookService bookService;

    static {
        connection = new DatabaseConnector().getConnection();
        authorRepository = new AuthorRepositoryImpl(connection);
        authorService = new AuthorServiceImpl(authorRepository);
        bookRepository = new BookRepositoryImpl(connection);
        bookService = new BookServiceImpl(bookRepository);
    }

    public static AuthorService getAuthorService() {
        return authorService;
    }

    public static BookService getBookService() {
        return bookService;
    }
}

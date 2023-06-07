package org.example.service;

import org.example.entity.Author;
import org.example.entity.Book;
import org.example.repository.AuthorRepository;
import org.example.util.ApplicationContext;

import java.sql.SQLException;
import java.util.Arrays;

public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void register(String firstName, String lastName, int age) throws SQLException {
        int authorId = authorRepository.save(new Author(firstName, lastName, age));
        System.out.println("Registered successfully.\nAuthor ID is: " + authorId);
    }

    @Override
    public void loadAuthorAndBooks(int authorId) throws SQLException {
        System.out.println(load(authorId));
        System.out.println(Arrays.toString(booksByAuthorId(authorId)));
    }

    @Override
    public Author load(int authorId) throws SQLException {
        Author result = authorRepository.load(authorId);
        if (result == null) {
            System.out.println("There is no such author. ");
            return null;
        } else return result;
    }

    private Book[] booksByAuthorId(int authorId) throws SQLException {
        BookService bookService = ApplicationContext.getBookService();
        Book[] books = bookService.loadByAuthorId(authorId);
        if (books == null) {
            System.out.println("This author has not any books. ");
            return null;
        } else
            return bookService.loadByAuthorId(authorId);
    }
}

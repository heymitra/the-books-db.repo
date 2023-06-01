package org.example.service;

import org.example.entity.Author;
import org.example.repository.AuthorRepository;
import org.example.repository.AuthorRepositoryImpl;

import java.sql.SQLException;
import java.util.Arrays;

public class AuthorServiceImpl implements AuthorService {

    AuthorRepository authorRepository = new AuthorRepositoryImpl();

    @Override
    public void register(Author author) throws SQLException {
        authorRepository.save(author);
    }

    @Override
    public Author load(int authorId) throws SQLException {
        BookService bookService = new BookServiceImpl();
        System.out.println(Arrays.toString(bookService.loadByAuthorId(authorId)));
        return authorRepository.load(authorId);
    }
}
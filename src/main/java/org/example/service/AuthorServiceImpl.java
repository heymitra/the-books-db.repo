package org.example.service;

import org.example.entity.Author;
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
    public void register(Author author) throws SQLException {
        authorRepository.save(author);
    }

    @Override
    public Author load(int authorId) throws SQLException {
        BookService bookService = ApplicationContext.getBookService();
        System.out.println(Arrays.toString(bookService.loadByAuthorId(authorId)));
        return authorRepository.load(authorId);
    }
}

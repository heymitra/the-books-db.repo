package org.example.service;

import org.example.entity.Book;
import org.example.repository.BookRepository;
import org.example.repository.BookRepositoryImpl;

import java.sql.SQLException;


public class BookServiceImpl implements BookService {

    BookRepository bookRepository = new BookRepositoryImpl();

    @Override
    public void addBook(Book book) throws SQLException {
        bookRepository.save(book);
    }

    @Override
    public Book load(int bookId) throws SQLException {
        return bookRepository.load(bookId);
    }

    @Override
    public void delete(Book book) throws SQLException {
        bookRepository.delete(book);
    }

    @Override
    public Book[] loadByAuthorId(int authorId) throws SQLException {
        return bookRepository.loadByAuthorId(authorId);
    }

}
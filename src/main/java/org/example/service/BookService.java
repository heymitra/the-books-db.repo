package org.example.service;

import org.example.entity.Book;

import java.sql.SQLException;

public interface BookService {
    void addBook(Book book) throws SQLException;
    Book load(int bookId) throws SQLException;
    void delete(Book book) throws SQLException;
    Book[] loadByAuthorId(int authorId) throws SQLException;
}

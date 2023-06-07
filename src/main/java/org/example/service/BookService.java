package org.example.service;

import org.example.entity.Book;

import java.sql.SQLException;

public interface BookService {
    void addBook(String title, String publishYear, int authorId) throws SQLException;

    void load(int bookId) throws SQLException;

    void delete(int bookId) throws SQLException;

    Book[] loadByAuthorId(int authorId) throws SQLException;
}

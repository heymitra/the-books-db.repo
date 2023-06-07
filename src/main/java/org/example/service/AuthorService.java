package org.example.service;

import org.example.entity.Author;

import java.sql.SQLException;

public interface AuthorService {
    void register (String firstName, String lastName, int age) throws SQLException;
    void loadAuthorAndBooks(int authorId) throws SQLException;
    Author load (int authorId) throws SQLException;
}

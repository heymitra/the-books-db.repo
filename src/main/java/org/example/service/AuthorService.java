package org.example.service;



import org.example.entity.Author;

import java.sql.SQLException;

public interface AuthorService {
    void register (Author author) throws SQLException;
    Author load (int authorId) throws SQLException;
}

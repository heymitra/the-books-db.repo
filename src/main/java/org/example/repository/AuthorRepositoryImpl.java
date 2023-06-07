package org.example.repository;

import org.example.entity.Author;

import java.sql.*;

public class AuthorRepositoryImpl implements AuthorRepository {

    private final Connection connection;

    public AuthorRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int save(Author author) throws SQLException {
        String insert = "insert into author (first_name, last_name, age) values (?, ?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(insert, PreparedStatement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, author.getFirstName());
        preparedStatement.setString(2, author.getLastName());
        preparedStatement.setInt(3, author.getAge());
        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();

        resultSet.next();
        author.setId(resultSet.getInt(1));
        return author.getId();
    }


    @Override
    public Author load(int authorId) throws SQLException {
        String load = "select * from author where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(load);
        preparedStatement.setInt(1, authorId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return new Author(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4));
        }
        return null;
    }
}

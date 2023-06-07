package org.example.repository;

import org.example.entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRepositoryImpl implements BookRepository {

    private final Connection connection;

    public BookRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int save(Book book) {
        try {
            // Create a PreparedStatement to insert a new book
            String insert = "insert into book (title, publish_year, author_id) values (?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(insert,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            // Set the parameters for the PreparedStatement
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getPublishYear());
            preparedStatement.setInt(3, book.getAuthorId());

            // Execute the PreparedStatement
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            resultSet.next();
            book.setId(resultSet.getInt(1));

        } catch (SQLException e) {
            // Check if the error is due to a foreign key constraint violation
            if (e.getSQLState().equals("23503"))
                return 0;
            else
                e.printStackTrace();

        }
        return book.getId();
    }

    @Override
    public Book load(int bookId) throws SQLException {
        String load = "select * from book where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(load);
        preparedStatement.setInt(1, bookId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return new Book(bookId,
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4));
        }
        return null;
    }

    @Override
    public Book[] loadByAuthorId(int authorId) throws SQLException {
        String loadByAuthorId = "select * from book where author_id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(loadByAuthorId,
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);

        preparedStatement.setInt(1, authorId);
        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.last();
        int len = resultSet.getRow();

        if (len == 0) {
            return null;
        } else {
            Book[] books = new Book[len];
            resultSet.beforeFirst();
            for (int i = 0; i < len; i++) {
                if (resultSet.next()) {
                    books[i] = new Book(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getInt(4)
                    );
                }
            }
            return books;
        }
    }

    @Override
    public void delete(int bookId) throws SQLException {
//        book.setId(findId(book));
        String delete = "delete from book where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1, bookId);
        preparedStatement.execute();
    }

//    private int findId(Book book) throws SQLException {
//        String find = "select id from book where  title = ? and publish_year = ? and author_id = ?;";
//        PreparedStatement preparedStatement = connection.prepareStatement(find);
//        preparedStatement.setString(1, book.getTitle());
//        preparedStatement.setString(2, book.getPublishYear());
//        preparedStatement.setInt(3, book.getAuthorId());
//        ResultSet resultSet = preparedStatement.executeQuery();
//        resultSet.next();
//        return resultSet.getInt(1);
//    }
}

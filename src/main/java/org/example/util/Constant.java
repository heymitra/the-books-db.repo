package org.example.util;

public class Constant {
    public static final String USERNAME = "postgres";
    public static final String PASSWORD = "postgrepass";
    public static final String URL = "jdbc:postgresql://localhost:5432/hw7";

    public static final String menu = "\n1. Insert new author" +
            "\n2. Insert new book" +
            "\n3. Load author and his books using author id" +
            "\n4. Load book info using book id" +
            "\n5. Delete a book" +
            "\nany other keys to exit";
}

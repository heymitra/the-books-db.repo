package org.example.ui;

import org.example.service.AuthorService;
import org.example.service.BookService;
import org.example.util.ApplicationContext;
import org.example.util.Constant;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    public static boolean stop;
    static Scanner input = new Scanner(System.in);

    public Menu() {
        stop = false;
        System.out.println("false");
    }

    public static void menu() throws SQLException {

        System.out.println(Constant.menu);

        int option = input.nextInt();

        switch (option) {
            case (1):
                saveAuthor();
                break;
            case (2):
                saveBook();
                break;
            case (3):
                loadAuthor();
                break;
            case (4):
                loadBook();
                break;
            case (5):
                deleteBook();
                break;
            default:
                System.out.println("Exited Successfully. ");
                stop = true;
                break;
        }
    }

    private static void saveAuthor() throws SQLException {
        AuthorService authorService = ApplicationContext.getAuthorService();

        System.out.print("First Name: ");
        String firstName = input.next();

        System.out.print("Last Name: ");
        String lastName = input.next();

        System.out.print("Age: ");
        int age = input.nextInt();

        authorService.register(firstName, lastName, age);
    }

    private static void saveBook() throws SQLException {
        BookService bookService = ApplicationContext.getBookService();

        System.out.print("Title: ");
        String title = input.next();

        System.out.print("Publish Year: ");
        String publishedYear = input.next();

        System.out.print("Author ID: ");
        int authorId = input.nextInt();

        bookService.addBook(title, publishedYear, authorId);
    }

    private static void loadAuthor() throws SQLException {
        AuthorService authorService = ApplicationContext.getAuthorService();
        System.out.print("Author ID: ");
        authorService.loadAuthorAndBooks(input.nextInt());
    }

    private static void loadBook() throws SQLException {
        BookService bookService = ApplicationContext.getBookService();
        System.out.print("Book ID: ");
        bookService.load(input.nextInt());
    }

    private static void deleteBook() throws SQLException {
        BookService bookService = ApplicationContext.getBookService();
        System.out.print("ID: ");
        bookService.delete(input.nextInt());
    }
}

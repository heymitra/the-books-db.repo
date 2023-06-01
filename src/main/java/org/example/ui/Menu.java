package org.example.ui;

import org.example.entity.Author;
import org.example.entity.Book;
import org.example.service.AuthorService;
import org.example.service.AuthorServiceImpl;
import org.example.service.BookService;
import org.example.service.BookServiceImpl;
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
                System.out.println("Exited Successfully");
                stop = true;
                break;
        }
    }

    private static void saveAuthor() throws SQLException {

        AuthorService authorService = ApplicationContext.getAuthorService();
        Author author = new Author();

        System.out.print("First Name: ");
        author.setFirstName(input.next());

        System.out.print("Last Name: ");
        author.setLastName(input.next());

        System.out.print("Age: ");
        author.setAge(input.nextInt());

        authorService.register(author);
    }

    private static void saveBook() throws SQLException {

        BookService bookService = ApplicationContext.getBookService();
        Book book = new Book();

        System.out.print("Title: ");
        book.setTitle(input.next());

        System.out.print("Publish Year: ");
        book.setPublishYear(input.next());

        System.out.print("Author ID: ");
        book.setAuthorId(input.nextInt());

        bookService.addBook(book);
    }

    private static void loadAuthor() throws SQLException {

        AuthorService authorService = ApplicationContext.getAuthorService();
        System.out.println("Author ID: ");
        System.out.println(authorService.load(input.nextInt()));
    }

    private static void loadBook() throws SQLException {

        BookService bookService = ApplicationContext.getBookService();
        System.out.println("Book ID: ");
        System.out.println(bookService.load(input.nextInt()));
    }

    private static void deleteBook() throws SQLException {

        BookService bookService = ApplicationContext.getBookService();
        Book book = new Book();

//        System.out.print("ID: ");
//        book.setId(input.nextInt());

        System.out.print("Title: ");
        book.setTitle(input.next());

        System.out.print("Publish Year: ");
        book.setPublishYear(input.next());

        System.out.print("Author ID: ");
        book.setAuthorId(input.nextInt());

        bookService.delete(book);
    }
}

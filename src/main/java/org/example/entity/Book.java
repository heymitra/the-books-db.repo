package org.example.entity;

public class Book {
    private int id;
    private String title;
    private String publishYear;
    private int authorId;

    public Book(String title, String publish_year, int authorId) {
        this.title = title;
        this.publishYear = publish_year;
        this.authorId = authorId;
    }

    public Book(int id, String title, String publish_year) {
        this.id = id;
        this.title = title;
        this.publishYear = publish_year;
    }

    public Book(int id, String title, String publishYear, int authorId) {
        this.id = id;
        this.title = title;
        this.publishYear = publishYear;
        this.authorId = authorId;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publishYear='" + publishYear + '\'' +
                ", authorId=" + authorId +
                '}';
    }
}

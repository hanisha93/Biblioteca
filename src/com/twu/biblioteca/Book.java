package com.twu.biblioteca;

public class Book {
    private String title, author;
    private String publishedYear;

    public Book(String title, String author, String publishedYear) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    @Override
    public String toString() {
        return title + ", " + author + ", " + publishedYear;
    }
}

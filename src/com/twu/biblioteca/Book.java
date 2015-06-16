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
        return title + "    | " + author + "       |" + publishedYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return title.equals(book.title);

    }

    public boolean matchBook(String title) {
        if (this.title.equals(title)) {
            return true;
        }
        return false;
    }
}

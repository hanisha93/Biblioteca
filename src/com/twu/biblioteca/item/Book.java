package com.twu.biblioteca.item;

import com.twu.biblioteca.Item;

public class Book implements Item {
    private String title, author;
    private String publishedYear;

    public Book(String title, String author, String publishedYear) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    @Override
    public boolean match(String title) {
        if (this.title.equals(title)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return title + " " + author + " " + publishedYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return title.equals(book.title);

    }

}

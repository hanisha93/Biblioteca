package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;

    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        String booksList = "";
        for (Book book : books) {
            booksList = booksList + "" + book.toString() + "\n";
        }
        return booksList;
    }
}


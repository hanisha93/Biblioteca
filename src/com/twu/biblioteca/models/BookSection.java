package com.twu.biblioteca.models;

import com.twu.biblioteca.models.Book;

import java.util.ArrayList;

public class BookSection {

    private ArrayList<Book> books;

    public BookSection(ArrayList<Book> books) {
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


package com.twu.biblioteca;

import java.util.ArrayList;

public class Books {

    private ArrayList<Book> listOfBooks = new ArrayList<Book>();

    public Books(ArrayList<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }

    @Override
    public String toString() {
        String booksList = "";
        for (Book book : listOfBooks) {
            booksList = booksList + "" + book.toString()+"\n";
        }
        return booksList;
    }
}
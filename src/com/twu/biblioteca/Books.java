package com.twu.biblioteca;

import java.util.ArrayList;

public class Books {

    private ArrayList<Book> listOfBooks = new ArrayList<Book>();

    public Books(ArrayList<Book> listOfBooks) {
        listOfBooks.add(new Book("Java", "wilson", "1998"));
        listOfBooks.add(new Book("c", "johnson","2000"));
        this.listOfBooks = listOfBooks;
    }

    @Override
    public String toString() {
        String booksList = "";
        for (Book book : listOfBooks) {
            booksList = booksList + "\\n" + book.toString();
        }
        return booksList;
    }
}
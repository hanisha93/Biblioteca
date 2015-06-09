package com.twu.biblioteca;


import java.util.ArrayList;

public class ListBooks implements MenuAction {

    @Override
    public void performAction() {
        OutputMessages msg = new OutputMessages();
        ArrayList<Book> bookList = new ArrayList<Book>();
        Books books = new Books(bookList);
        msg.displayListOfBooks(books);

    }
}

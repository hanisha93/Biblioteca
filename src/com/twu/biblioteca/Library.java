package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> listOfBooks;

    public Library(ArrayList<Book> listOfBooks) {
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

    public Book compareBook(Book book) {
        for(Book eachBook :listOfBooks) {
            if(book.equals(eachBook)) {
                return eachBook;
            }
        }
        return null;
    }
}
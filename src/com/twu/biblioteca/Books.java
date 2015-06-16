package com.twu.biblioteca;

import java.util.ArrayList;

public class Books {

    private ArrayList<Book> listOfBooks;

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

    public ArrayList<Book> compareBooks(String title,ArrayList<Book> result) {
        for(Book eachBook : listOfBooks)
        if(eachBook.matchBook(title)) {
            result.add(eachBook);
        }
        return result;
    }
}
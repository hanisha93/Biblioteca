package com.twu.biblioteca;

import java.util.ArrayList;

public class Books {

    private ArrayList<Book> listOfBooks = new ArrayList<Book>();

    public Books() {
        listOfBooks.add(new Book("oopconcepts","wilson","2000"));
        listOfBooks.add(new Book("javaProgramming","johnson","1998"));
    }

    @Override
    public String toString() {
        return  ""+listOfBooks;
    }
}
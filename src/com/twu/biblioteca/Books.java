package com.twu.biblioteca;

import java.util.ArrayList;

public class Books {

    private ArrayList<String> listOfBooks = new ArrayList<String>();

    public Books() {
        listOfBooks.add("oopconcepts");
        listOfBooks.add("javaProgramming");
    }

    public ArrayList<String> listBooks() {
        return listOfBooks;
    }

    @Override
    public String toString() {
        return "Books{" +
                "listOfBooks=" + listOfBooks +
                '}';
    }
}
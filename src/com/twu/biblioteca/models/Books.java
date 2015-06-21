package com.twu.biblioteca.models;

import com.twu.biblioteca.Item;
import com.twu.biblioteca.item.Book;

import java.util.ArrayList;

public class Books {

    private ArrayList<Item> books;

    public Books(ArrayList<Item> books) {
        this.books = books;

    }

    @Override
    public String toString() {
        String booksList = "";
        for (Item book : books) {
            booksList += "     "+book.toString() + "\n";
        }
        return booksList;
    }
}


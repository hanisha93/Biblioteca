package com.twu.biblioteca;


import java.util.ArrayList;

public class ListBooks implements MenuAction {

    @Override
    public void handleOption() {

        ArrayList<Book> bookList = new ArrayList<Book>();
        Books books = new Books(bookList);
        BibliotecaView bibliotecaView = new BibliotecaView();

    }
}

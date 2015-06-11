package com.twu.biblioteca;

public class BooksHandler {
    private BibliotecaView bibliotecaView;
    private Books books;

    public BooksHandler(BibliotecaView bibliotecaView, Books books) {
        this.bibliotecaView = bibliotecaView;
        this.books = books;
    }

    public void listBooks() {
        bibliotecaView.printToConsole(books.toString());
    }

    public void displayInvalidOption() {
        bibliotecaView.printToConsole(Messages.INVALID_OPTION);
    }
}

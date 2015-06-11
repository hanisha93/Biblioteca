package com.twu.biblioteca;

public class ListBooks implements MenuAction{
    private BooksHandler booksHandler;

    public ListBooks(BooksHandler booksHandler) {
        this.booksHandler = booksHandler;
    }

    @Override
    public void handleOption() {
        booksHandler.listBooks();
    }
}

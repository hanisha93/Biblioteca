package com.twu.biblioteca;

public class InvalidOption implements MenuAction{
    private BooksHandler booksHandler;

    public InvalidOption(BooksHandler booksHandler) {
        this.booksHandler = booksHandler;
    }

    @Override
    public void handleOption() {
        booksHandler.displayInvalidOption();
    }
}

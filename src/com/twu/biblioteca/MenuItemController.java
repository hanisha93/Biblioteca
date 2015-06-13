package com.twu.biblioteca;

import java.util.ArrayList;

import static com.twu.biblioteca.Messages.*;
//controlling all items in menu
public class MenuItemController {
    private View view;

    public MenuItemController(View view) {
        this.view = view;
    }

    public void listBooks(Books books) {
        view.printToConsole(books.toString());
    }

    public void invalidOption() {
        view.printToConsole(INVALID_OPTION);
    }

    public void checkOut(ArrayList<Book> checkedOutBooks , ArrayList<Book> booksList) {
        view.printToConsole(CHECKOUT_BOOK);
        String bookName = view.readBook();
        for(Book book : booksList) {
        }
    }

}

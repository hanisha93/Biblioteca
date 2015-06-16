package com.twu.biblioteca;

import java.util.ArrayList;

import static com.twu.biblioteca.Messages.*;

//controlling all items in menu
public class MenuItemController {
    private View view;
    private Library library;
    public MenuItemController(View view,Library library) {
        this.view = view;
        this.library = library;
    }

    public void listBooks(Library library) {
        view.printToConsole(library.toString());
    }

    public void invalidOption() {
        view.printToConsole(INVALID_OPTION);
    }

    public void checkOut(ArrayList<Book> result) {
        view.printToConsole(CHECKOUT_BOOK);
        String title = view.readInput();
        library.searchBook(title, result);
        String message = library.doCheckout(result);
        view.printToConsole(message);
    }

    public void returnBook(ArrayList<Book> result) {
        view.printToConsole(RETURN_BOOK);
        String title = view.readInput();
        library.searchCheckedOutList(title, result);
        String message = library.returnBook(result);
        view.printToConsole(message);
    }
}

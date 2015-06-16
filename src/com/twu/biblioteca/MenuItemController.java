package com.twu.biblioteca;

import java.util.ArrayList;

import static com.twu.biblioteca.Messages.*;

//controlling all items in menu
public class MenuItemController {
    private View view;
    private Librarian librarian;

    public MenuItemController(View view, Librarian librarian) {
        this.view = view;
        this.librarian = librarian;
    }

    public void listBooks(Library library) {
        view.printToConsole(library.toString());
    }

    public void invalidOption() {
        view.printToConsole(INVALID_OPTION);
    }

    public void checkOut(ArrayList<Book> matchedBook) {
        view.printToConsole(CHECKOUT_BOOK);
        String title = view.readInput();
        matchedBook.clear();
        librarian.searchBook(title, matchedBook);
        String message = librarian.doCheckout(matchedBook);
        view.printToConsole(message);
    }

    public void returnBook(ArrayList<Book> result) {
        view.printToConsole(RETURN_BOOK);
        String title = view.readInput();
        result.clear();
        librarian.searchCheckedOutList(title, result);
        String message = librarian.returnBook(result);
        view.printToConsole(message);
    }
}

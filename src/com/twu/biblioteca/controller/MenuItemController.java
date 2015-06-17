package com.twu.biblioteca.controller;

import com.twu.biblioteca.View;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Librarian;
import com.twu.biblioteca.models.BookSection;

import java.util.ArrayList;

import static com.twu.biblioteca.Messages.*;

//controls all items in menu

public class MenuItemController {
    private View view;
    private Librarian librarian;

    public MenuItemController(View view, Librarian librarian) {
        this.view = view;
        this.librarian = librarian;
    }

    public void listBooks(BookSection bookSection) {
        view.printToConsole(bookSection.toString());
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

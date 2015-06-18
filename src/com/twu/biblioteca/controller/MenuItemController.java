package com.twu.biblioteca.controller;

import com.twu.biblioteca.Item;
import com.twu.biblioteca.View;
import com.twu.biblioteca.models.*;

import java.util.ArrayList;

import static com.twu.biblioteca.Messages.*;

//controls all items in menu

public class MenuItemController {
    private View view;
    private ArrayList<Item> searchResult;

    public MenuItemController(View view, ArrayList<Item> searchResult) {
        this.view = view;
        this.searchResult = searchResult;
    }

    public void listBooks(Books books) {
        view.printToConsole(books.toString());
    }

    public void invalidOption() {
        view.printToConsole(INVALID_OPTION);
    }

    public void checkOut(Librarian librarian, String item, String libraryNo) {
        view.printToConsole("Enter " + item + " to checkout");
        String title = view.readInput();
        searchResult.clear();
        librarian.searchItem(title, searchResult);
        String message = librarian.doCheckout(searchResult, item, libraryNo);
        view.printToConsole(message);
    }

    public void returnBook(Librarian librarian, String item, String libraryNo) {
        view.printToConsole("Enter " + item + " to Return");
        String title = view.readInput();
        searchResult.clear();
        librarian.searchCheckedOutList(title, searchResult);
        String message = librarian.returnItem(searchResult, item, libraryNo);
        view.printToConsole(message);
    }

    public void listMovies(Movies movies) {
        view.printToConsole(movies.toString());
    }

}

package com.twu.biblioteca.controller;

import com.twu.biblioteca.Item;
import com.twu.biblioteca.View;
import com.twu.biblioteca.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
        view.printToConsole("     " + books.toString());
    }

    public void invalidOption() {
        view.printToConsole(INVALID_OPTION);
    }

    public void checkOut(LibrarianJob librarianJob, String item, String libraryNo) {
        view.printToConsole("     Enter " + item + " to checkout\n     ");
        String title = view.readInput();
        searchResult.clear();
        librarianJob.searchItem(title, searchResult);
        String message = librarianJob.doCheckout(searchResult, item, libraryNo);
        view.printToConsole("     " + message);
    }

    public void returnBook(LibrarianJob librarianJob, String item, String libraryNo) {
        view.printToConsole("     Enter " + item + " to ReturnOption\n     ");
        String title = view.readInput();
        searchResult.clear();
        librarianJob.searchCheckedOutList(title, searchResult, libraryNo);
        String message = librarianJob.acceptReturnItem(searchResult, item, libraryNo);
        view.printToConsole("     " + message);
    }

    public void listMovies(Movies movies) {
        view.printToConsole(movies.toString());
    }

    public void handleCheckoutDetails(LibrarianJob librarianJob) {
        HashMap<Item, String> users = librarianJob.getCheckOutDetails();
        for (Map.Entry<Item, String> entry : users.entrySet()) {
            view.printToConsole("     " + entry.getKey() + "   " + entry.getValue() + "\n     ");
        }
    }

    public void displayUserInformation(ArrayList<UserProfile> userProfiles, String libraryNo) {
        for (UserProfile userProfile : userProfiles) {
            if (userProfile.matchLibraryId(libraryNo)) {
                view.printToConsole("     " + userProfile.toString());
            }
        }
    }
}

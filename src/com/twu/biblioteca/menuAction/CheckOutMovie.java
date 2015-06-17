package com.twu.biblioteca.menuAction;

import com.twu.biblioteca.controller.MenuItemController;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Movie;

import java.util.ArrayList;

public class CheckOutMovie implements MenuAction {
    private MenuItemController menuItemController;
    private ArrayList<Movie> searchResult;

    public CheckOutMovie(MenuItemController menuItemController, ArrayList<Movie> searchResult) {
        this.menuItemController = menuItemController;
        this.searchResult = searchResult;
    }

    @Override
    public void performAction() {
        menuItemController.checkOutMovie(searchResult);
    }
}

package com.twu.biblioteca.menuAction;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.controller.MenuItemController;

import java.util.ArrayList;

public class CheckOutBook implements MenuAction {

    private MenuItemController menuItemController;
    private ArrayList<Book> searchResult;

    public CheckOutBook(MenuItemController menuItemController, ArrayList<Book> searchResult) {
        this.menuItemController = menuItemController;
        this.searchResult = searchResult;
    }

    @Override
    public void performAction() {
        menuItemController.checkOut(searchResult);
    }
}

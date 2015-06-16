package com.twu.biblioteca;

import java.util.ArrayList;

public class CheckOut implements MenuAction {

    private MenuItemController menuItemController;
    private ArrayList<Book> searchResult;
    public CheckOut(MenuItemController menuItemController,  ArrayList<Book> searchResult) {
        this.menuItemController = menuItemController;
        this.searchResult = searchResult;
    }

    @Override
    public void handleOption() {
        menuItemController.checkOut(searchResult);
    }
}

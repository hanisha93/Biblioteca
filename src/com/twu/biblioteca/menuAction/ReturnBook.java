package com.twu.biblioteca.menuAction;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.controller.MenuItemController;

import java.util.ArrayList;


public class ReturnBook implements MenuAction {

    private MenuItemController menuItemController;
    private ArrayList<Book> searchResult;

    public ReturnBook(MenuItemController menuItemController, ArrayList<Book> searchResult) {
        this.menuItemController = menuItemController;
        this.searchResult = searchResult;
    }

    @Override
    public void performAction() {
        menuItemController.returnBook(searchResult);
    }
}


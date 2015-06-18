package com.twu.biblioteca.menuAction;

import com.twu.biblioteca.Item;
import com.twu.biblioteca.item.Book;
import com.twu.biblioteca.controller.MenuItemController;
import com.twu.biblioteca.models.Librarian;

import java.util.ArrayList;

public class CheckOut implements MenuAction {

    private MenuItemController menuItemController;
    private Librarian librarian;
    private String item;

    public CheckOut(MenuItemController menuItemController, Librarian librarian, String item) {
        this.menuItemController = menuItemController;
        this.librarian = librarian;
        this.item =item;
    }

    @Override
    public void performAction(String libraryNo) {
        menuItemController.checkOut(librarian, item,libraryNo);
    }
}

package com.twu.biblioteca.menuAction;

import com.twu.biblioteca.models.Books;
import com.twu.biblioteca.controller.MenuItemController;

public class ListBooks implements MenuAction {
    private MenuItemController menuItemController;
    private Books books;

    public ListBooks(MenuItemController menuItemController, Books books) {
        this.menuItemController = menuItemController;
        this.books = books;
    }

    @Override
    public void performAction(String libraryNo) {
        menuItemController.listBooks(books);
    }
}

package com.twu.biblioteca.CommonMenuAction;

import com.twu.biblioteca.models.Books;
import com.twu.biblioteca.controller.MenuItemController;

public class ListBooks implements CommonMenuAction {
    private MenuItemController menuItemController;
    private Books books;

    public ListBooks(MenuItemController menuItemController, Books books) {
        this.menuItemController = menuItemController;
        this.books = books;
    }

    @Override
    public void performMenuAction() {
        menuItemController.listBooks(books);
    }
}

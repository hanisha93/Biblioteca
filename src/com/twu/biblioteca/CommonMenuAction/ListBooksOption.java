package com.twu.biblioteca.CommonMenuAction;

import com.twu.biblioteca.models.Books;
import com.twu.biblioteca.controller.MenuItemController;

public class ListBooksOption implements CommonMenuAction {
    private MenuItemController menuItemController;
    private Books books;

    public ListBooksOption(MenuItemController menuItemController, Books books) {
        this.menuItemController = menuItemController;
        this.books = books;
    }

    @Override
    public void performMenuAction() {
        menuItemController.listBooks(books);
    }
}

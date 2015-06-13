package com.twu.biblioteca;

public class ListBooks implements MenuAction {
    private MenuItemController menuItemController;
    private Books books;

    public ListBooks(MenuItemController menuItemController, Books books) {
        this.menuItemController = menuItemController;
        this.books = books;
    }

    @Override
    public void handleOption() {
        menuItemController.listBooks(books);
    }
}

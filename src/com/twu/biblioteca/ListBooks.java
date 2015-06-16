package com.twu.biblioteca;

public class ListBooks implements MenuAction {
    private MenuItemController menuItemController;
    private Library library;

    public ListBooks(MenuItemController menuItemController, Library library) {
        this.menuItemController = menuItemController;
        this.library = library;
    }

    @Override
    public void handleOption() {
        menuItemController.listBooks(library);
    }
}

package com.twu.biblioteca.menuAction;

import com.twu.biblioteca.models.BookSection;
import com.twu.biblioteca.controller.MenuItemController;

public class ListBooks implements MenuAction {
    private MenuItemController menuItemController;
    private BookSection bookSection;

    public ListBooks(MenuItemController menuItemController, BookSection bookSection) {
        this.menuItemController = menuItemController;
        this.bookSection = bookSection;
    }

    @Override
    public void performAction() {
        menuItemController.listBooks(bookSection);
    }
}

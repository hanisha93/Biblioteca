package com.twu.biblioteca.menuAction;

import com.twu.biblioteca.controller.MenuItemController;
import com.twu.biblioteca.menuAction.MenuAction;
import com.twu.biblioteca.models.LibrarianJob;

public class CheckedOutItemDetailsOption implements MenuAction {
    private MenuItemController menuItemController;
    private LibrarianJob librarianJob;

    public CheckedOutItemDetailsOption(MenuItemController menuItemController, LibrarianJob librarianJobHandlesBooks) {
        this.menuItemController = menuItemController;
        this.librarianJob = librarianJobHandlesBooks;
    }

    @Override
    public void performAction(String libraryNo) {
        menuItemController.handleCheckoutDetails(librarianJob);
    }
}

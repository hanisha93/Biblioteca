package com.twu.biblioteca.menuAction;

import com.twu.biblioteca.controller.MenuItemController;
import com.twu.biblioteca.menuAction.MenuAction;
import com.twu.biblioteca.models.LibrarianJob;

public class CheckedOutItemDetails implements MenuAction {
    private MenuItemController menuItemController;
    private LibrarianJob librarianJob;

    public CheckedOutItemDetails(MenuItemController menuItemController, LibrarianJob librarianJobHandlesBooks) {
        this.menuItemController = menuItemController;
        this.librarianJob = librarianJobHandlesBooks;
    }

    @Override
    public void performAction(String libraryNo) {
        menuItemController.handleCheckoutDetails(librarianJob);
    }
}

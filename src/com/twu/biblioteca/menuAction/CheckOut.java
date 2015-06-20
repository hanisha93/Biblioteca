package com.twu.biblioteca.menuAction;

import com.twu.biblioteca.controller.MenuItemController;
import com.twu.biblioteca.models.LibrarianJob;

public class CheckOut implements MenuAction {

    private MenuItemController menuItemController;
    private LibrarianJob librarianJob;
    private String item;

    public CheckOut(MenuItemController menuItemController, LibrarianJob librarianJob, String item) {
        this.menuItemController = menuItemController;
        this.librarianJob = librarianJob;
        this.item = item;
    }

    @Override
    public void performAction(String libraryNo) {
        menuItemController.checkOut(librarianJob, item, libraryNo);
    }
}

package com.twu.biblioteca.menuAction;

import com.twu.biblioteca.controller.MenuItemController;
import com.twu.biblioteca.models.LibrarianJob;


public class Return implements MenuAction {

    private MenuItemController menuItemController;
    private LibrarianJob librarianJob;
    private String item;

    public Return(MenuItemController menuItemController, LibrarianJob librarianJob, String item) {
        this.menuItemController = menuItemController;
        this.librarianJob = librarianJob;
        this.item = item;
    }

    @Override
    public void performAction(String libraryNo) {
        menuItemController.returnBook(librarianJob, item, libraryNo);
    }
}


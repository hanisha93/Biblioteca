package com.twu.biblioteca.controller;

import com.twu.biblioteca.View;

public class UserController {
    private View view;
    private MenuController menuController;
    public UserController(View view, MenuItemController menuItemController) {
        this.menuController = menuController;
        this.view =view;
    }

    public void handleLibrarianOptions() {
        view.printToConsole("LIBRARIAN_OPTIONS");
    }
}

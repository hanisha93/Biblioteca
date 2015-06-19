package com.twu.biblioteca.controller;

import com.twu.biblioteca.View;

public class UserController {
    private View view;
    private MenuController menuController;

    public void handleLibrarianOptions() {
        view.printToConsole("LIBRARIAN_OPTIONS");
        String option = view.readInput();
    }
}

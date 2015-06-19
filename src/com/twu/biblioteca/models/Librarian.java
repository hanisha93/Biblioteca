package com.twu.biblioteca.models;

import com.twu.biblioteca.User;
import com.twu.biblioteca.controller.UserController;

public class Librarian implements User {
    private UserController userController;

    public Librarian(UserController userController) {
        this.userController = userController;
    }

    @Override
    public void perform() {
        userController.handleLibrarianOptions();
    }
}

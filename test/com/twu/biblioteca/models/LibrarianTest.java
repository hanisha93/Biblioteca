package com.twu.biblioteca.models;

import com.twu.biblioteca.User;
import com.twu.biblioteca.controller.UserController;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LibrarianTest {

    @Test
    public void specToCheckLibrarianUserOptionCallingUserController() {
        UserController userController = mock(UserController.class);
        Librarian librarian = new Librarian(userController);
        librarian.perform();
        verify(userController).displayLibrarianOptions();
    }

}
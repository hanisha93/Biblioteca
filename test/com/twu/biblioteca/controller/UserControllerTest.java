package com.twu.biblioteca.controller;

import com.twu.biblioteca.View;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class UserControllerTest {

    @Test
    public void specToCheckHandleLibrarianOptions() {
        View view = mock(View.class);
        MenuItemController menuItemController = mock(MenuItemController.class);
        UserController userController = new UserController(view, menuItemController);
        userController.handleLibrarianOptions();

        verify(view).printToConsole(anyString());
    }
}
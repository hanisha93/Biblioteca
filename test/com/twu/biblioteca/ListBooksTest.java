package com.twu.biblioteca;

import com.twu.biblioteca.controller.MenuItemController;
import com.twu.biblioteca.models.Library;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListBooksTest {

    @Test
    public void specToCheckHandleOption() {
        Library library = mock(Library.class);
        MenuItemController menuItemController = mock(MenuItemController.class);
        menuAction.ListBooks listBooks = new menuAction.ListBooks(menuItemController, library);
        listBooks.handleOption();

        verify(menuItemController, Mockito.times(1)).listBooks(library);
    }

}
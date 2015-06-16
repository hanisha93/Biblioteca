package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListBooksTest {

    @Test
    public void specToCheckHandleOption() {
        Library library= mock(Library.class);
        MenuItemController menuItemController = mock(MenuItemController.class);
        ListBooks listBooks = new ListBooks(menuItemController,library);
        listBooks.handleOption();

        verify(menuItemController, Mockito.times(1)).listBooks(library);
    }

}
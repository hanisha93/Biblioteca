package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListBooksTest {

    @Test
    public void specToCheckHandleOption() {
        Books books = mock(Books.class);
        MenuItemController menuItemController = mock(MenuItemController.class);
        ListBooks listBooks = new ListBooks(menuItemController,books);
        listBooks.handleOption();

        verify(menuItemController, Mockito.times(1)).listBooks(books);
    }

}
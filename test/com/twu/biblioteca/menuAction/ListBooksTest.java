package com.twu.biblioteca.menuAction;

import com.twu.biblioteca.CommonMenuAction.CommonMenuAction;
import com.twu.biblioteca.CommonMenuAction.ListBooks;
import com.twu.biblioteca.controller.MenuItemController;
import com.twu.biblioteca.models.Books;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListBooksTest {

    @Test
    public void testPerformAction() {
        Books books = mock(Books.class);
        MenuItemController menuItemController = mock(MenuItemController.class);
        ListBooks listBooks = new ListBooks(menuItemController, books);
        listBooks.performMenuAction();

        verify(menuItemController, Mockito.times(1)).listBooks(books);
    }

}
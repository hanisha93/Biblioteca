package com.twu.biblioteca.commonMenuAction;

import com.twu.biblioteca.CommonMenuAction.ListBooksOption;
import com.twu.biblioteca.controller.MenuItemController;
import com.twu.biblioteca.models.Books;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListBooksOptionTest {

    @Test
    public void testPerformAction() {
        Books books = mock(Books.class);
        MenuItemController menuItemController = mock(MenuItemController.class);
        ListBooksOption listBooksOption = new ListBooksOption(menuItemController, books);
        listBooksOption.performMenuAction();

        verify(menuItemController, Mockito.times(1)).listBooks(books);
    }

}
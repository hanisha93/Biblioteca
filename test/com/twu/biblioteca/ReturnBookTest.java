package com.twu.biblioteca;

import com.twu.biblioteca.controller.MenuItemController;
import com.twu.biblioteca.models.Book;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ReturnBookTest {

    @Test
    public void specToCheckHandleOptionInReturn() {
        ArrayList<Book> searchResult = new ArrayList<Book>();

        MenuItemController menuItemController = mock(MenuItemController.class);
        menuAction.ReturnBook returnBook = new menuAction.ReturnBook(menuItemController, searchResult);
        returnBook.handleOption();

        verify(menuItemController).returnBook(searchResult);
    }
}
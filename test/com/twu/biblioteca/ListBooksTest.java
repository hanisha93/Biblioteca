package com.twu.biblioteca;

import com.twu.biblioteca.controller.MenuItemController;
import com.twu.biblioteca.menuAction.ListBooks;
import com.twu.biblioteca.models.BookSection;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListBooksTest {

    @Test
    public void specToCheckHandleOption() {
        BookSection bookSection = mock(BookSection.class);
        MenuItemController menuItemController = mock(MenuItemController.class);
        ListBooks listBooks = new ListBooks(menuItemController, bookSection);
        listBooks.performAction();

        verify(menuItemController, Mockito.times(1)).listBooks(bookSection);
    }

}
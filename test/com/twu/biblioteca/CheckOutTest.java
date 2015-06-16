package com.twu.biblioteca;

import com.twu.biblioteca.controller.MenuItemController;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Librarian;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CheckOutTest {

    @Test
    public void specToCheckHandleOptionInCheckOut() {
        ArrayList<Book> searchResult = new ArrayList<Book>();
        Librarian librarian = mock(Librarian.class);
        MenuItemController menuItemController = mock(MenuItemController.class);
        menuAction.CheckOut checkOut = new menuAction.CheckOut(menuItemController, searchResult);
        checkOut.handleOption();

        verify(menuItemController, Mockito.times(1)).checkOut(searchResult);
    }
}
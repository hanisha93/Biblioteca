package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CheckOutTest {

    @Test
    public void specToCheckHandleOptionInCheckOut() {
        ArrayList<Book> checkedOutBooks = new ArrayList<Book>();
        ArrayList<Book> booksList = new ArrayList<Book>();
        Library library = new Library(booksList, checkedOutBooks);
        MenuItemController menuItemController = mock(MenuItemController.class);
        CheckOut checkOut = new CheckOut(menuItemController, booksList, checkedOutBooks);
        checkOut.handleOption();

        verify(menuItemController, Mockito.times(1)).checkOut(checkedOutBooks, booksList);
    }
}
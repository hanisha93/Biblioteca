package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ReturnTest {

    @Test
    public void specToCheckHandleOptionInReturn() {
        ArrayList<Book> checkedOutBooks = new ArrayList<Book>();
        ArrayList<Book> booksList = new ArrayList<Book>();
        MenuItemController menuItemController = mock(MenuItemController.class);
        Return returnBook = new Return(menuItemController , booksList,checkedOutBooks);
        returnBook.handleOption();

        verify(menuItemController, Mockito.times(1)).returnBook(checkedOutBooks, booksList);
    }

}
package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static com.twu.biblioteca.Messages.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MenuItemControllerTest {

    @Test
    public void specToCheckListBooksMenuItem() {

        View view = mock(View.class);
        Books books = mock(Books.class);
        MenuItemController menuItemController = new MenuItemController(view);

        menuItemController.listBooks(books);

        verify(view, Mockito.times(1)).printToConsole(books.toString());
    }

    @Test
    public void specToCheckCheckOutBookMenuItemDisplayingCheckOutMessage() {

        View view = mock(View.class);
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        ArrayList<Book> checkedOutList = new ArrayList<Book>();
        MenuItemController menuItemController = new MenuItemController(view);
        menuItemController.checkOut(checkedOutList, listOfBooks);

        verify(view, Mockito.times(1)).printToConsole(CHECKOUT_BOOK);
    }

    @Test
    public void specToCheckCheckOutBookMenuItemTakingBookToBeCheckedOut() {

        View view = mock(View.class);
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        ArrayList<Book> checkedOutList = new ArrayList<Book>();
        MenuItemController menuItemController = new MenuItemController(view);
        menuItemController.checkOut(checkedOutList ,listOfBooks);

        verify(view, Mockito.times(1)).readBook();
    }

    
}
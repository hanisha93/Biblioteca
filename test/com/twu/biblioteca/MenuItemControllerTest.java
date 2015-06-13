package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuItemControllerTest {

    @Test
    public void specToCheckListBooksMenuItem() {

        BibliotecaView view = mock(BibliotecaView.class);
        Books books = mock(Books.class);
        MenuItemController menuItemController = new MenuItemController(view);

        menuItemController.listBooks(books);

        verify(view, Mockito.times(1)).printToConsole(books.toString());

    }

}
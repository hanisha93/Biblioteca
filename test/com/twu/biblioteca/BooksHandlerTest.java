package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BooksHandlerTest {

    @Test
    public void specToCheckCallingPrintListOfBooksInBibliotecaView() {

        View view = mock(View.class);
        Books books = mock(Books.class);
        MenuItemController menuItemController = new MenuItemController(view);
        menuItemController.listBooks(books);

        verify(view, Mockito.times(1)).printToConsole(books.toString());
    }

}
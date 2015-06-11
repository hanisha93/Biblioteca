package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BooksHandlerTest {

    @Test
    public void specToCheckCallingPrintListOfBooksInBibliotecaView() {

        BibliotecaView bibliotecaView = mock(BibliotecaView.class);
        Books books = mock(Books.class);
        BooksHandler booksHandler = new BooksHandler(bibliotecaView , books);
        booksHandler.listBooks();

        verify(bibliotecaView, Mockito.times(1)).printToConsole(books.toString());
    }

}
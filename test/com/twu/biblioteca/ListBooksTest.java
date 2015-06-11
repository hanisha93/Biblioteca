package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListBooksTest {

    @Test
    public void specToCheckHandleOption() {

        BooksHandler booksHandler = mock(BooksHandler.class);
        ListBooks listBooks = new ListBooks(booksHandler);
        listBooks.handleOption();

        verify(booksHandler, Mockito.times(1)).listBooks();
    }

}
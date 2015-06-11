package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class InvalidOptionTest {

    @Test
    public void specToCheckHandleInvalidOption() {

        BooksHandler booksHandler = mock(BooksHandler.class);
        InvalidOption invalidOption = new InvalidOption(booksHandler);
        invalidOption.handleOption();

        verify(booksHandler, Mockito.times(1)).displayInvalidOption();
    }

}
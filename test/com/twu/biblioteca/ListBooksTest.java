package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListBooksTest {

/*
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void specToCheckListBooksOption() {

        Books booksStubOne= mock(Books.class);
        when(booksStubOne.toString()).thenReturn("\\noopconcepts wilson  2000\\njavaProgramming johnson  1998");
        OutputMessages msg = new OutputMessages();
        msg.displayListOfBooks(booksStubOne);
        ListBooks listBooks = new ListBooks();
        listBooks.phandleOption();

        assertEquals("\\noopconcepts wilson  2000\\njavaProgramming johnson  1998", outContent.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }*/
}
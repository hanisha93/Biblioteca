package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BooksTest {

    @Test
    public void specForCheckingToString() {
        Book bookStubOne= mock(Book.class);
        Book bookStubTwo= mock(Book.class);
        when(bookStubOne.toString()).thenReturn("oopconcepts wilson  2000");
        when(bookStubTwo.toString()).thenReturn("javaProgramming johnson  1998");

        ArrayList<Book> list=new ArrayList<Book>();
        list.add(bookStubOne);
        list.add(bookStubTwo);

        Books listOfBooks = new Books(list);

        String actualBooks = listOfBooks.toString();
        String expectedBooks = "\\noopconcepts wilson  2000\\njavaProgramming johnson  1998";

        assertEquals(actualBooks, expectedBooks);
    }
}


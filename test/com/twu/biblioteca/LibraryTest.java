package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class LibraryTest {

    @Test
    public void specForCheckingToString() {
        ArrayList<Book> list=new ArrayList<Book>();
        list.add(new Book("Java", "wilson", "1998"));
        list.add(new Book("c", "johnson","2000"));
        Library listOfLibrary = new Library(list);

        String actualBooks = listOfLibrary.toString();
        String expectedBooks = "Java wilson  1998\nc johnson  2000\n";

        assertEquals(actualBooks, expectedBooks);
    }
}


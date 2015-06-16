package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LibraryTest {

    @Test
    public void specForCheckingToString() {
        ArrayList<Book> list = new ArrayList<Book>();
        list.add(new Book("Java", "wilson", "1998"));
        list.add(new Book("c", "johnson", "2000"));

        Library listOfBooks = new Library(list);

        String actualBooks = listOfBooks.toString();
        String expectedBooks = "Java wilson 1998\nc johnson 2000\n";

        assertEquals(actualBooks, expectedBooks);
    }
}
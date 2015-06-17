package com.twu.biblioteca;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.BookSection;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BookSectionTest {

    @Test
    public void specForCheckingToString() {
        ArrayList<Book> list = new ArrayList<Book>();
        list.add(new Book("Java", "wilson", "1998"));
        list.add(new Book("c", "johnson", "2000"));

        BookSection listOfBooks = new BookSection(list);

        String actualBooks = listOfBooks.toString();
        String expectedBooks = "Java wilson 1998\nc johnson 2000\n";

        assertEquals(actualBooks, expectedBooks);
    }
}
package com.twu.biblioteca.models;

import com.twu.biblioteca.Item;
import com.twu.biblioteca.item.Book;
import com.twu.biblioteca.models.Books;
import com.twu.biblioteca.item.Movie;
import com.twu.biblioteca.models.Movies;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BooksTest {

    @Test
    public void specForCheckingToString() {
        ArrayList<Item> list = new ArrayList<Item>();
        list.add(new Book("Java", "wilson", "1998"));
        list.add(new Book("c", "johnson", "2000"));

        Books listOfBooks = new Books(list);

        String actualBooks = listOfBooks.toString();
        String expectedBooks = "     Java wilson 1998\n     c johnson 2000\n";

        assertEquals(actualBooks, expectedBooks);
    }
}
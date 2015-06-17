package com.twu.biblioteca;

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
        String expectedBooks = "Java wilson 1998\nc johnson 2000\n";

        assertEquals(actualBooks, expectedBooks);
    }

    public static class MoviesTest {

        @Test
        public void specForCheckingToString() {
            ArrayList<Item> moviesList = new ArrayList<Item>();
            moviesList.add(new Movie("Avatar","2011","cameroon","7"));
            moviesList.add(new Movie("2012", "2011","james" , "5"));
            Movies movies = new Movies(moviesList);

            String actualBooks = movies.toString();
            String expectedBooks = "Avatar  2011  cameroon  7*\n" +
                    "2012  2011  james  5*\n";

            assertEquals(actualBooks, expectedBooks);
        }

    }
}
package com.twu.biblioteca.models;

import com.twu.biblioteca.Item;
import com.twu.biblioteca.item.Movie;
import com.twu.biblioteca.models.Movies;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MoviesTest {

    @Test
    public void specForCheckingToString() {
        ArrayList<Item> moviesList = new ArrayList<Item>();
        moviesList.add(new Movie("Avatar","2011","cameroon","7"));
        moviesList.add(new Movie("2012", "2011","james" , "5"));
        Movies movies = new Movies(moviesList);

        String actualBooks = movies.toString();
        String expectedBooks = "     Avatar  2011  cameroon  7*\n" +
                "     2012  2011  james  5*\n";

        assertEquals(actualBooks, expectedBooks);
    }

}
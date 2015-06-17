package com.twu.biblioteca.models;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MoviesSectionTest {

    @Test
    public void specForCheckingToString() {
        ArrayList<Movie> moviesList = new ArrayList<Movie>();
        moviesList.add(new Movie("Avatar","2011","cameroon","7"));
        moviesList.add(new Movie("2012", "2011","james" , "5"));
        MoviesSection moviesSection = new MoviesSection(moviesList);

        String actualBooks = moviesSection.toString();
        String expectedBooks = "Avatar  2011  cameroon  7*\n" +
                "2012  2011  james  5*\n";

        assertEquals(actualBooks, expectedBooks);
    }

}
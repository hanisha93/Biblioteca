package com.twu.biblioteca.item;

import com.twu.biblioteca.item.Movie;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class MovieTest {

    @Test
    public void specToTestToString() {
        Movie movie = new Movie("Avatar", "2011", "Cameroon", "7");

        String actualMovie = movie.toString();
        String expectedMovie = "Avatar  2011  Cameroon  7*";

        assertThat(actualMovie, is(expectedMovie));
    }

    @Test
    public void specToTestMatchMovieReturnsTrueWhenMovieNameMatches() {
        Movie movie = new Movie("Avatar", "2011", "Cameroon", "7");

        boolean matched = movie.match("Avatar");

        assertTrue(matched);
    }

    @Test
    public void specToTestMatchMovieReturnsTrueWhenMovieNameDoesNotMatches() {
        Movie movie = new Movie("Avatar", "2011", "Cameroon", "7");

        boolean matched = movie.match("vatar");

        assertFalse(matched);
    }
}
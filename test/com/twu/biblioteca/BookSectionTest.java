package com.twu.biblioteca;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.BookSection;
import com.twu.biblioteca.models.Movie;
import com.twu.biblioteca.models.MoviesSection;
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

    public static class MoviesSectionTest {

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
}
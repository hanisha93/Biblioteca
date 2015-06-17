package com.twu.biblioteca.menuAction;

import com.twu.biblioteca.controller.MenuItemController;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Librarian;
import com.twu.biblioteca.models.Movie;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CheckOutMovieTest {

    @Test
    public void specToCheckPerformActionInCheckOutMovie() {
        ArrayList<Movie> searchResult = new ArrayList<Movie>();
        Librarian librarian = mock(Librarian.class);
        MenuItemController menuItemController = mock(MenuItemController.class);
        CheckOutMovie checkOutMovie = new CheckOutMovie(menuItemController, searchResult);
        checkOutMovie.performAction();

        verify(menuItemController, Mockito.times(1)).checkOutMovie(searchResult);
    }
}
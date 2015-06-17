package com.twu.biblioteca;

import com.twu.biblioteca.controller.MenuItemController;
import com.twu.biblioteca.menuAction.ListMovies;
import com.twu.biblioteca.models.BookSection;
import com.twu.biblioteca.models.MoviesSection;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListMoviesTest {
    @Test
    public void specToCheckPerformActionOfListingMovies() {
        MoviesSection movieSection = mock(MoviesSection.class);
        MenuItemController menuItemController = mock(MenuItemController.class);
        ListMovies listMovies = new ListMovies(menuItemController, movieSection);
        listMovies.performAction();

        verify(menuItemController, Mockito.times(1)).listMovies(movieSection);
    }

}
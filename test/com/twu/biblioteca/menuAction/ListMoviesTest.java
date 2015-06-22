package com.twu.biblioteca.menuAction;

import com.twu.biblioteca.CommonMenuAction.CommonMenuAction;
import com.twu.biblioteca.CommonMenuAction.ListMovies;
import com.twu.biblioteca.controller.MenuItemController;
import com.twu.biblioteca.models.Movies;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListMoviesTest {
    @Test
    public void testPerformActionOfListingMovies() {
        Movies movieSection = mock(Movies.class);
        MenuItemController menuItemController = mock(MenuItemController.class);
        ListMovies listMovies = new ListMovies(menuItemController, movieSection);
        listMovies.performMenuAction();

        verify(menuItemController, Mockito.times(1)).listMovies(movieSection);
    }

}
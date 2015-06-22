package com.twu.biblioteca.commonMenuAction;

import com.twu.biblioteca.CommonMenuAction.ListMoviesOption;
import com.twu.biblioteca.controller.MenuItemController;
import com.twu.biblioteca.models.Movies;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListMoviesOptionTest {
    @Test
    public void testPerformActionOfListingMovies() {
        Movies movieSection = mock(Movies.class);
        MenuItemController menuItemController = mock(MenuItemController.class);
        ListMoviesOption listMoviesOption = new ListMoviesOption(menuItemController, movieSection);
        listMoviesOption.performMenuAction();

        verify(menuItemController, Mockito.times(1)).listMovies(movieSection);
    }

}
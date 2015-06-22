package com.twu.biblioteca.CommonMenuAction;

import com.twu.biblioteca.controller.MenuItemController;
import com.twu.biblioteca.models.Movies;

public class ListMoviesOption implements CommonMenuAction {

    private MenuItemController menuItemController;
    private Movies movies;
    public ListMoviesOption(MenuItemController menuItemController, Movies movies) {
        this.menuItemController = menuItemController;
        this.movies = movies;
    }

    @Override
    public void performMenuAction() {
        menuItemController.listMovies(movies);
    }
}

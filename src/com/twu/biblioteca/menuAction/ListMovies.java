package com.twu.biblioteca.menuAction;

import com.twu.biblioteca.controller.MenuItemController;
import com.twu.biblioteca.models.Movies;

public class ListMovies implements MenuAction {

    private MenuItemController menuItemController;
    private Movies movies;
    public ListMovies(MenuItemController menuItemController, Movies movies) {
        this.menuItemController = menuItemController;
        this.movies = movies;
    }

    @Override
    public void performAction(String t) {
        menuItemController.listMovies(movies);
    }
}

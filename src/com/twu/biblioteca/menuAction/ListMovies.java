package com.twu.biblioteca.menuAction;

import com.twu.biblioteca.controller.MenuItemController;
import com.twu.biblioteca.menuAction.MenuAction;
import com.twu.biblioteca.models.MoviesSection;

public class ListMovies implements MenuAction {

    private MenuItemController menuItemController;
    private MoviesSection moviesSection;
    public ListMovies(MenuItemController menuItemController, MoviesSection moviesSection) {
        this.menuItemController = menuItemController;
        this.moviesSection = moviesSection;
    }

    @Override
    public void performAction() {
        menuItemController.listMovies(moviesSection);
    }
}

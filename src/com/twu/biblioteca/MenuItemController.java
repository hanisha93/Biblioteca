package com.twu.biblioteca;

public class MenuItemController {
    private View view;

    public MenuItemController(View view) {
        this.view = view;
    }

    public void listBooks(Books books) {
        view.printToConsole(books.toString());
    }

    public void InvalidOption() {
        view.printToConsole(Messages.INVALID_OPTION);
    }

}

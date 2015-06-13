package com.twu.biblioteca;

import java.util.ArrayList;

public class CheckOut implements MenuAction {

    private MenuItemController menuItemController;
    private ArrayList<Book> checkedOutBooks = new ArrayList<Book>();
    private ArrayList<Book> booksList = new ArrayList<Book>();

    public CheckOut(MenuItemController menuItemController, ArrayList booksList) {
        this.menuItemController = menuItemController;
        this.booksList = booksList;
    }

    @Override
    public void handleOption() {
        menuItemController.checkOut(checkedOutBooks, booksList);
    }
}

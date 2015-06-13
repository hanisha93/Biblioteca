package com.twu.biblioteca;

import java.util.ArrayList;

public class CheckOut implements MenuAction {

    private MenuItemController menuItemController;
    private ArrayList<Book> booksList;
    private ArrayList<Book> checkedOutBooks;
    public CheckOut(MenuItemController menuItemController, ArrayList<Book> booksList, ArrayList<Book> checkedOutList) {
        this.menuItemController = menuItemController;
        this.booksList = booksList;
        this.checkedOutBooks = checkedOutList;
    }

    @Override
    public void handleOption() {
        menuItemController.checkOut(checkedOutBooks, booksList);
    }
}

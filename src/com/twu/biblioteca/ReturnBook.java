package com.twu.biblioteca;

import java.util.ArrayList;

public class ReturnBook implements MenuAction {

    private MenuItemController menuItemController;
    private ArrayList<Book> booksList;
    private ArrayList<Book> checkedOutBooks;

    public ReturnBook(MenuItemController menuItemController, ArrayList<Book> booksList, ArrayList<Book> checkedOutBooks) {
        this.menuItemController = menuItemController;
        this.booksList = booksList;
        this.checkedOutBooks = checkedOutBooks;
    }

    @Override
    public void handleOption() {
        //menuItemController.returnBook(checkedOutBooks, booksList);
    }
}

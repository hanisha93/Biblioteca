package com.twu.biblioteca;

import java.util.ArrayList;

public class Return implements MenuAction {

    private  MenuItemController menuItemController;
    private ArrayList<Book> searchResult;
    public Return(MenuItemController menuItemController, ArrayList<Book> searchResult) {
        this.menuItemController = menuItemController;
        this.searchResult = searchResult;

    }

    @Override
    public void handleOption() {
        menuItemController.returnBook(searchResult);
    }
}

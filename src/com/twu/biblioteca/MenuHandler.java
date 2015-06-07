package com.twu.biblioteca;

public class MenuHandler {

    private int option;

    public void selectMenu(int option) {
        OutputMessages msg = new OutputMessages();
        msg.displayMenu();
        switch (option) {
            case 1:
                Books books = new Books();
                msg.displayListOfBooks(books);
                break;
        }
    }
}

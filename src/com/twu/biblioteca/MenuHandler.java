package com.twu.biblioteca;

public class MenuHandler {

    private int option;

    public void viewOption() {
        OutputMessages msg = new OutputMessages();
        msg.displayMenu();
    }

    public void selectOption(int option) {
        boolean quit = false;
        OutputMessages msg = new OutputMessages();
        switch (option) {
            case 1:
                Books books = new Books();
                msg.displayListOfBooks(books);
                break;
            default:
                msg.displayInvalidOption();
        }
    }
}

package com.twu.biblioteca;

public class MenuHandler {

    private int option;

    public MenuHandler(int option) {
        this.option = option;
    }

    public void selectedMenu() {
        switch (option) {
            case 1:
                OutputMessages msg = new OutputMessages();
                Books books = new Books();
                msg.displayListOfBooks(books);
                break;
        }
    }
}

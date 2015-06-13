package com.twu.biblioteca;

public class MenuItemController {
    private BibliotecaView bibliotecaView;

    public MenuItemController(BibliotecaView bibliotecaView) {
        this.bibliotecaView = bibliotecaView;
    }

    public void listBooks(Books books) {
        bibliotecaView.printToConsole(books.toString());
    }

    public void InvalidOption() {
        bibliotecaView.printToConsole(Messages.INVALID_OPTION);
    }

}

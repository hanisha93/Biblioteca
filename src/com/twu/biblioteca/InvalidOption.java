package com.twu.biblioteca;

public class InvalidOption implements MenuAction{
    private BibliotecaView bibliotecaView;

    public InvalidOption(BibliotecaView view) {
        this.bibliotecaView = view;
    }
    @Override
    public void handleOption() {
        bibliotecaView.printToConsole(Messages.INVALID_OPTION);
    }
}

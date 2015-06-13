package com.twu.biblioteca;

public class InvalidOption implements MenuAction{
    private View view;

    public InvalidOption(View view) {
        this.view = view;
    }
    @Override
    public void handleOption() {
        view.printToConsole(Messages.INVALID_OPTION);
    }
}

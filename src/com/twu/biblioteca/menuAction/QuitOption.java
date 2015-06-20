package com.twu.biblioteca.menuAction;

public class QuitOption implements MenuAction {
    private boolean quit;

    public QuitOption(boolean quit) {
        this.quit = quit;
    }

    @Override
    public void performAction(String libraryNo) {
        System.exit(1);
    }
}

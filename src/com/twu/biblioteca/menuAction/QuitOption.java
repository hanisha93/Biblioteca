package com.twu.biblioteca.menuAction;

public class QuitOption implements MenuAction {

    @Override
    public void performAction(String libraryNo) {
        System.exit(0);
    }
}

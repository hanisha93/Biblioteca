package com.twu.biblioteca;

import java.util.HashMap;

public class MenuController implements Messages {

    private HashMap<Integer, MenuAction> menuAction;
    private View view;

    public MenuController(HashMap<Integer, MenuAction> menuAction, View view) {
        this.menuAction = menuAction;
        this.view = view;
    }

    public void handleRequest(int option) {
        if(menuAction.containsKey(option)) {
            MenuAction menu = menuAction.get(option);
            menu.handleOption();
        }
        else {
            view.printToConsole(Messages.INVALID_OPTION);
        }
    }
}

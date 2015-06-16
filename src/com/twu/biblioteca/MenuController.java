package com.twu.biblioteca;

import java.util.HashMap;

public class MenuController implements Messages {

    private HashMap<String, MenuAction> menuAction;
    private View view;


    public MenuController(HashMap<String, MenuAction> menuAction, View view) {
        this.menuAction = menuAction;
        this.view = view;
    }

    public void handleRequest(String option) {
        if (menuAction.containsKey(option)) {
            MenuAction menu = menuAction.get(option);
            menu.handleOption();
        } else if (!option.equals("0")) {
            view.printToConsole(Messages.INVALID_OPTION);
        }
    }
}

package com.twu.biblioteca.controller;

import com.twu.biblioteca.menuAction.MenuAction;
import com.twu.biblioteca.Messages;
import com.twu.biblioteca.View;

import java.util.HashMap;

public class MenuController implements Messages {

    private HashMap<String, MenuAction> menuAction;
    private View view;

    public MenuController(HashMap<String, MenuAction> menuAction, View view) {
        this.menuAction = menuAction;
        this.view = view;
    }

    public void handleOption(String option) {
        if (menuAction.containsKey(option)) {
            MenuAction menu = menuAction.get(option);
            menu.performAction();
        } else if (!option.equals("0")) {
            view.printToConsole(Messages.INVALID_OPTION);
        }
    }
}

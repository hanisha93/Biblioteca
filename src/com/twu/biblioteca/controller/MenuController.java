package com.twu.biblioteca.controller;

import com.twu.biblioteca.menuAction.MenuAction;
import com.twu.biblioteca.Messages;
import com.twu.biblioteca.View;

import java.util.HashMap;

public class MenuController implements Messages {

    private HashMap<String, MenuAction> menuAction;
    private View view;
    private String menu;

    public MenuController(HashMap<String, MenuAction> menuAction, View view, String menu) {
        this.menuAction = menuAction;
        this.view = view;
        this.menu = menu;
    }

    public void handleOption(String option,String libraryNo) {
        if (menuAction.containsKey(option)) {
            MenuAction menu = menuAction.get(option);
            menu.performAction(libraryNo);
        } else if (!option.equals("0")) {
            view.printToConsole(Messages.INVALID_OPTION);
        }
    }

    public void displayMenu() {
        view.printToConsole(menu);
        view.printToConsole(CHOOSE_OPTION);
    }

}

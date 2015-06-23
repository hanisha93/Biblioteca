package com.twu.biblioteca.controller;

import com.twu.biblioteca.CommonMenuAction.CommonMenuAction;
import com.twu.biblioteca.menuAction.MenuAction;
import com.twu.biblioteca.Messages;
import com.twu.biblioteca.View;

import java.util.HashMap;
//handles different MenuActions
public class MenuController implements Messages {

    private View view;
    private String menu;

    public MenuController(View view, String menu) {
        this.view = view;
        this.menu = menu;
    }

    public void handleOption(String option, String libraryNo, HashMap<String, MenuAction> menuAction) {
        if (menuAction.containsKey(option)) {
            MenuAction menu = menuAction.get(option);
            menu.performAction(libraryNo);
        } else if (!option.equals("0")) {
            view.printToConsole(Messages.INVALID_OPTION);
        }
    }

    public void handleCommonMenuOption(String option, HashMap<String ,CommonMenuAction> commonMenuAction) {
        if (commonMenuAction.containsKey(option)) {
            CommonMenuAction menu = commonMenuAction.get(option);
            menu.performMenuAction();
        } else if (!option.equals("3")) {
            view.printToConsole(Messages.INVALID_OPTION);
        }
    }

    public void displayMenu() {
        view.printToConsole(menu);
        view.printToConsole(CHOOSE_OPTION);
    }

}

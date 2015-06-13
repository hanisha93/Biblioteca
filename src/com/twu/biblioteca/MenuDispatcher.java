package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;

public class MenuDispatcher implements Messages {

    private HashMap<Integer, MenuAction> menuAction;
    private BibliotecaView view;

    public MenuDispatcher(HashMap<Integer, MenuAction> menuAction ,BibliotecaView view) {
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

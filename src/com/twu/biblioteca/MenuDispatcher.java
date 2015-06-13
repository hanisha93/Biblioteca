package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;

public class MenuDispatcher implements Messages {

    private HashMap<Integer, MenuAction> menuAction;

    public MenuDispatcher(HashMap<Integer, MenuAction> menuAction) {
        this.menuAction = menuAction;
    }

    public void handleRequest(int option) {
        if(menuAction.containsKey(option)) {
            MenuAction menu = menuAction.get(option);
            menu.handleOption();
        }
        else {
            
        }
    }
}

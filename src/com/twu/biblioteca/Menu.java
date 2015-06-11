package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;

public class Menu implements Messages{

    private HashMap<Integer, MenuAction> menuAction;

    public Menu(HashMap<Integer, MenuAction> menuAction) {
        this.menuAction = menuAction;
    }

    public void handleRequest(int action) {
        MenuAction menu = menuAction.get(action);
        menu.handleOption();
    }
}

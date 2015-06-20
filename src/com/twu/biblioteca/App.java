package com.twu.biblioteca;

import com.twu.biblioteca.controller.MenuController;
import com.twu.biblioteca.controller.UserValidation;
import com.twu.biblioteca.menuAction.MenuAction;

import java.util.HashMap;

import static com.twu.biblioteca.Messages.*;

public class App {

    public void start(View view, HashMap<String, HashMap<String, MenuAction>> menu, UserValidation userValidation, HashMap<String, String> printMenu, boolean quit) {
        String option="";
        while (!quit) {
            view.printToConsole(ENTER_LIBID);
            String libraryId = view.readInput();
            view.printToConsole(ENTER_PWD);
            String password = view.readInput();
            String role = userValidation.validateUser(libraryId, password);
            if (role != null) {
                MenuController menuController = new MenuController(menu.get(role), view, printMenu.get(role));
                menuController.displayMenu();
                while (!option.equals("0")) {
                    option = view.readInput();
                    menuController.handleOption(option, libraryId);
                }
            } else
                view.printToConsole(LOGIN_FAIL);
        }
    }

}

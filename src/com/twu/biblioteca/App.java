package com.twu.biblioteca;

import com.twu.biblioteca.controller.MenuController;
import com.twu.biblioteca.controller.UserValidation;
import com.twu.biblioteca.menuAction.MenuAction;

import java.util.HashMap;

import static com.twu.biblioteca.Messages.*;

public class App {

    public void start(View view, HashMap<String, HashMap<String, MenuAction>> menu, UserValidation userValidation, HashMap<String, String> printMenu) {
        while (true) {
            view.printToConsole(ENTER_LIBID);
            String libraryId = view.readInput();
            view.printToConsole(ENTER_PWD);
            String password = view.readInput();
            String role = userValidation.validateUser(libraryId, password);
            if (role != null) {

                String option = view.readInput();
                MenuController menuController = new MenuController(menu.get(role), view, printMenu.get(role));
                menuController.handleOption(option, libraryId);
                while (!option.equals("7")) {
                    option = view.readInput();
                    menuController.handleOption(option, libraryId);
                }
            } else
                view.printToConsole(LOGIN_FAIL);
        }
    }

}

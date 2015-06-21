package com.twu.biblioteca;

import com.twu.biblioteca.controller.MenuController;
import com.twu.biblioteca.models.UserValidation;
import com.twu.biblioteca.menuAction.MenuAction;

import java.util.HashMap;

import static com.twu.biblioteca.Messages.*;

public class App {

    public void start(View view, HashMap<String, HashMap<String, MenuAction>> menu, UserValidation userValidation, HashMap<String, String> printMenu) {
        String option, role;
        boolean quit = false;
        while (!quit) {
            view.printToConsole(WELCOME_MESSAGE);
            option = "";
            view.printToConsole(ENTER_LIBID);
            String libraryId = view.readInput();
            view.printToConsole(ENTER_PWD);
            String password = view.readInput();
            role = userValidation.validateUser(libraryId, password);
            if (role != null) {
                MenuController menuController = new MenuController(menu.get(role), view, printMenu.get(role));
                while (!option.equals("0")) {
                    menuController.displayMenu();
                    option = view.readInput();
                    if (option.equals("9")) {
                        quit = true;
                        break;
                    }
                    menuController.handleOption(option, libraryId);
                }
            } else
                view.printToConsole(LOGIN_FAIL);
        }
    }

}

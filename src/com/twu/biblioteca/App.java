package com.twu.biblioteca;

import com.twu.biblioteca.CommonMenuAction.CommonMenuAction;
import com.twu.biblioteca.controller.MenuController;
import com.twu.biblioteca.models.UserValidation;
import com.twu.biblioteca.menuAction.MenuAction;

import java.util.HashMap;

import static com.twu.biblioteca.Messages.*;

public class App {

    public void start(View view, HashMap<String, HashMap<String, MenuAction>> menu, UserValidation userValidation,
                      HashMap<String, String> printMenu, MenuController commonMenuController, HashMap<String, CommonMenuAction> commonMenuAction) {
        String option, role;
        boolean quit = false;
        while (!quit) {
            view.printToConsole(WELCOME_MESSAGE);
            option = "";
            commonMenuController.displayMenu();
            option = view.readInput();
            if (option.equals("3")) {
                view.printToConsole(ENTER_LIBID);
                String libraryId = view.readInput();
                view.printToConsole(ENTER_PWD);
                String password = view.readInput();
                role = userValidation.validateUser(libraryId, password);
                if (role != null) {
                    MenuController menuController = new MenuController(view, printMenu.get(role));
                    while (!option.equals("0")) {
                        menuController.displayMenu();
                        option = view.readInput();
                        if (option.equals("7") && (role.equals("librarian"))) {
                            quit = true;
                            break;
                        }
                        menuController.handleOption(option, libraryId, menu.get(role));
                    }
                } else if (option.equals("3"))
                    view.printToConsole(LOGIN_FAIL);
            } else
                commonMenuController.handleCommonMenuOption(option, commonMenuAction);
        }
    }

}

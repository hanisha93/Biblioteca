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
            option = getOption(view, commonMenuController);
            if (option.equals("3")) {
                String libraryId = getLibraryId(view);
                String password = view.readInput();
                role = userValidation.validateUser(libraryId, password);
                quit = isLibrarianLogin(view, menu, printMenu, option, role, quit, libraryId);
            } else
                commonMenuController.handleCommonMenuOption(option, commonMenuAction);
        }
    }

    private boolean isLibrarianLogin(View view, HashMap<String, HashMap<String, MenuAction>> menu, HashMap<String, String> printMenu, String option, String role, boolean quit, String libraryId) {
        if (role != null) {
            MenuController menuController = new MenuController(view, printMenu.get(role));
            quit = isQuit(view, menu, option, role, quit, libraryId, menuController);
        } else if (option.equals("3"))
            view.printToConsole(LOGIN_FAIL);
        return quit;
    }

    private String getLibraryId(View view) {
        view.printToConsole(ENTER_LIBID);
        String libraryId = view.readInput();
        view.printToConsole(ENTER_PWD);
        return libraryId;
    }

    private String getOption(View view, MenuController commonMenuController) {
        String option;
        view.printToConsole(WELCOME_MESSAGE);
        option = "";
        commonMenuController.displayMenu();
        option = view.readInput();
        return option;
    }

    private boolean isQuit(View view, HashMap<String, HashMap<String, MenuAction>> menu, String option, String role, boolean quit, String libraryId, MenuController menuController) {
        while (!option.equals("0")) {
            menuController.displayMenu();
            option = view.readInput();
            if (option.equals("7") && (role.equals("librarian"))) {
                quit = true;
                break;
            }
            menuController.handleOption(option, libraryId, menu.get(role));
        }
        return quit;
    }

}

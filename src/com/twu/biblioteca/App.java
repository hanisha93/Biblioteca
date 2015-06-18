package com.twu.biblioteca;

import com.twu.biblioteca.controller.MenuController;
import com.twu.biblioteca.controller.UserValidation;

import static com.twu.biblioteca.Messages.*;

public class App {

    public void start(View view, MenuController menuController, UserValidation userValidation) {
        view.printToConsole(ENTER_LIBID);
        String libraryId = view.readInput();
        view.printToConsole(ENTER_PWD);
        String password = view.readInput();
        userValidation.validateUser(libraryId, password);

            view.printToConsole(LOGIN_SUCCESS);
            printMessage(view);
            String option = view.readInput();
            menuController.handleOption(option);
            while (!option.equals("0")) {
                printMessage(view);
                option = view.readInput();
                menuController.handleOption(option);
            }
        }


    private void printMessage(View view) {
        view.printToConsole(MENU_LIST);
        view.printToConsole(CHOOSE_OPTION);
    }
}

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
        boolean validate = userValidation.validateUser(libraryId, password);
        if(validate) {
            printMessage(view);
            String option = view.readInput();
            menuController.handleOption(option,libraryId);
            while (!option.equals("0")) {
                printMessage(view);
                option = view.readInput();
                menuController.handleOption(option,libraryId);
            }
        }
    }


    private void printMessage(View view) {
        view.printToConsole(MENU_LIST);
        view.printToConsole(CHOOSE_OPTION);
    }
}

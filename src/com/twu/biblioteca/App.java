package com.twu.biblioteca;

import com.twu.biblioteca.controller.MenuController;

import static com.twu.biblioteca.Messages.*;

public class App {

    public void start(View view, MenuController menuController) {

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

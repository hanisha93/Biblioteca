package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static com.twu.biblioteca.Messages.*;

public class App {

    public void start(View view,MenuController menuController ) {
        int option = getOption(view, menuController);
        while(option!=0) {
            option = getOption(view, menuController);
        }
    }

    private int getOption(View view, MenuController menuController) {
        printMenu(view);
        int option = view.readInput();
        menuController.handleRequest(option);
        return option;
    }

    private void printMenu(View view) {
        view.printToConsole(MENU_LIST);
        view.printToConsole(CHOOSE_OPTION);
    }
}

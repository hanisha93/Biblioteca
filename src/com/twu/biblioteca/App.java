package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static com.twu.biblioteca.Messages.*;

public class App {

    public void start(View view, MenuController menuController) {

        printMessage(view);
        String option = view.readInput();
        menuController.handleRequest(option);
        while (!option.equals("0")) {
            printMessage(view);
            option = view.readInput();
            menuController.handleRequest(option);
        }
    }

    private void printMessage(View view) {
        view.printToConsole(MENU_LIST);
        view.printToConsole(CHOOSE_OPTION);
    }

}

package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class App {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> list = new ArrayList<Book>();
        View view = new View(scanner);

        list.add(new Book("java", "john", "2000"));
        Books books = new Books(list);

        HashMap<Integer, MenuAction> menuAction = new HashMap<Integer, MenuAction>();
        MenuItemController menuItemController = new MenuItemController(view);
        menuAction.put(1, new ListBooks(menuItemController, books));


        view.printToConsole(Messages.WELCOME_MESSAGE);
        view.printToConsole(Messages.MENU_LIST);
        view.printToConsole(Messages.CHOOSE_OPTION);
        int option = view.readInput();

        MenuController menuDispatcher = new MenuController(menuAction,view);
        menuDispatcher.handleRequest(option);

    }
}

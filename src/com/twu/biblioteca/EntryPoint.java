package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EntryPoint {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> booksList = new ArrayList<Book>();
        ArrayList<Book> checkedOutBooks = new ArrayList<Book>();
        View view = new View(scanner);
        booksList.add(new Book("java", "john", "2000"));
        booksList.add(new Book("oop", "jhn", "2001"));
        checkedOutBooks.add(new Book("","",""));
        Books books = new Books(booksList);
        HashMap<Integer, MenuAction> menuAction = new HashMap<Integer, MenuAction>();
        MenuItemController menuItemController = new MenuItemController(view);
        menuAction.put(1, new ListBooks(menuItemController, books));
        menuAction.put(2, new CheckOut(menuItemController, booksList,checkedOutBooks));
        menuAction.put(3, new Return(menuItemController, booksList,checkedOutBooks));
        view.printToConsole(Messages.WELCOME_MESSAGE);
        MenuController menuController = new MenuController(menuAction, view);
        App app = new App();

        app.start(view, menuController);
    }
}

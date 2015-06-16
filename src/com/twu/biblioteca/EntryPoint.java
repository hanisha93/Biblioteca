package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EntryPoint {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> booksList = new ArrayList<Book>();
        ArrayList<Book> checkedOutBooks = new ArrayList<Book>();
        ArrayList<Book> searchResult = new ArrayList<>();
        View view = new View(scanner);
        booksList.add(new Book("java", "john", "2000"));
        booksList.add(new Book("oop", "jhn", "2001"));
        checkedOutBooks.add(new Book("","",""));
        Library library = new Library(booksList,checkedOutBooks);
        HashMap<String, MenuAction> menuAction = new HashMap<String, MenuAction>();
        MenuItemController menuItemController = new MenuItemController(view,library);
        menuAction.put("1", new ListBooks(menuItemController, library));
        menuAction.put("2", new CheckOut(menuItemController,searchResult));
        menuAction.put("3", new Return(menuItemController, booksList,checkedOutBooks));
        view.printToConsole(Messages.WELCOME_MESSAGE);
        MenuController menuController = new MenuController(menuAction, view);
        App app = new App();

        app.start(view, menuController);
    }
}

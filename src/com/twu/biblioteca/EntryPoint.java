package com.twu.biblioteca;

import com.twu.biblioteca.controller.MenuController;
import com.twu.biblioteca.controller.MenuItemController;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Librarian;
import com.twu.biblioteca.models.Library;

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
        booksList.add(new Book("oop concepts", "john", "2000"));
        booksList.add(new Book("The Lord Of Rings", "wilson", "2001"));
        checkedOutBooks.add(new Book("", "", ""));
        Librarian librarian = new Librarian(booksList, checkedOutBooks);
        Library library = new Library(booksList);
        HashMap<String, MenuAction> menuAction = new HashMap<String, MenuAction>();
        MenuItemController menuItemController = new MenuItemController(view, librarian);
        menuAction.put("1", new menuAction.ListBooks(menuItemController, library));
        menuAction.put("2", new menuAction.CheckOut(menuItemController, searchResult));
        menuAction.put("3", new menuAction.ReturnBook(menuItemController, searchResult));
        view.printToConsole(Messages.WELCOME_MESSAGE);
        MenuController menuController = new MenuController(menuAction, view);
        App app = new App();

        app.start(view, menuController);
    }
}

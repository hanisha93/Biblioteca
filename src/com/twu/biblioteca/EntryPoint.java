package com.twu.biblioteca;

import com.twu.biblioteca.controller.MenuController;
import com.twu.biblioteca.controller.MenuItemController;
import com.twu.biblioteca.controller.UserValidation;
import com.twu.biblioteca.item.Book;
import com.twu.biblioteca.item.Movie;
import com.twu.biblioteca.menuAction.*;

import com.twu.biblioteca.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EntryPoint {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Item> booksList = new ArrayList<Item>();
        ArrayList<Item> moviesList = new ArrayList<Item>();
        ArrayList<Item> checkedOutBooks = new ArrayList<Item>();
        ArrayList<Item> checkedOutMovies = new ArrayList<Item>();
        ArrayList<Item> searchResult = new ArrayList<Item>();
        ArrayList<LibraryUser> libraryUsers = new ArrayList<LibraryUser>();
        libraryUsers.add(new LibraryUser("b01-0001", "hanisha"));
        libraryUsers.add(new LibraryUser("b01-0002", "priya"));

        View view = new View(scanner);

        booksList.add(new Book("oop concepts", "john", "2000"));
        booksList.add(new Book("The Lord Of Rings", "wilson", "2001"));
        checkedOutBooks.add(new Book("", "", ""));
        moviesList.add(new Movie("Avatar", "cameroon", "2011", "7"));

        Librarian librarianHandlesBooks = new Librarian(booksList, checkedOutBooks);
        Librarian librarianHandlesMovies = new Librarian(moviesList, checkedOutMovies);
        UserValidation userValidation = new UserValidation(libraryUsers);

        Books books = new Books(booksList);
        Movies movies = new Movies(moviesList);

        HashMap<String, MenuAction> menuAction = new HashMap<String, MenuAction>();
        MenuItemController menuItemController = new MenuItemController(view, searchResult);
        menuAction.put("1", new ListBooks(menuItemController, books));
        menuAction.put("2", new CheckOut(menuItemController, librarianHandlesBooks, "book"));
        menuAction.put("3", new Return(menuItemController, librarianHandlesBooks, "book"));
        menuAction.put("4", new ListMovies(menuItemController, movies));
        menuAction.put("5", new CheckOut(menuItemController, librarianHandlesMovies, "movie"));
        menuAction.put("6", new Return(menuItemController, librarianHandlesMovies, "movie"));

        view.printToConsole(Messages.WELCOME_MESSAGE);
        MenuController menuController = new MenuController(menuAction, view);
        App app = new App();

        app.start(view, menuController, userValidation);
    }
}

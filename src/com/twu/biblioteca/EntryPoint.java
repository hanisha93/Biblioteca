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
        libraryUsers.add(new LibraryUser("b01-0001", "hanisha", "admin"));
        libraryUsers.add(new LibraryUser("b01-0002", "priya", "user"));

        View view = new View(scanner);

        HashMap<Item, String> checkedOutItemsAndUsers = new HashMap<>();
        HashMap<String, User> roleOfUser = new HashMap<>();

        booksList.add(new Book("oop concepts", "john", "2000"));
        booksList.add(new Book("The Lord Of Rings", "wilson", "2001"));
        checkedOutBooks.add(new Book("", "", ""));
        moviesList.add(new Movie("Avatar", "cameroon", "2011", "7"));
        LibrarianJob librarianJobHandlesBooks = new LibrarianJob(booksList, checkedOutBooks, checkedOutItemsAndUsers);
        LibrarianJob librarianJobHandlesMovies = new LibrarianJob(moviesList, checkedOutMovies, checkedOutItemsAndUsers);
        UserValidation userValidation = new UserValidation(libraryUsers);

        Books books = new Books(booksList);
        Movies movies = new Movies(moviesList);

        HashMap<String, MenuAction> menuAction = new HashMap<String, MenuAction>();
        MenuItemController menuItemController = new MenuItemController(view, searchResult);
        menuAction.put("1", new ListBooks(menuItemController, books));
        menuAction.put("2", new CheckOut(menuItemController, librarianJobHandlesBooks, "book"));
        menuAction.put("3", new Return(menuItemController, librarianJobHandlesBooks, "book"));
        menuAction.put("4", new ListMovies(menuItemController, movies));
        menuAction.put("5", new CheckOut(menuItemController, librarianJobHandlesMovies, "movie"));
        menuAction.put("6", new Return(menuItemController, librarianJobHandlesMovies, "movie"));

        HashMap<String, MenuAction> librarianMenuAction = new HashMap<>();
        librarianMenuAction.put("1", new ListBooks(menuItemController, books));
        librarianMenuAction.put("2", new CheckOut(menuItemController, librarianJobHandlesBooks, "book"));
        librarianMenuAction.put("3", new Return(menuItemController, librarianJobHandlesBooks, "book"));
        librarianMenuAction.put("4", new ListMovies(menuItemController, movies));
        librarianMenuAction.put("5", new CheckOut(menuItemController, librarianJobHandlesMovies, "movie"));
        librarianMenuAction.put("6", new Return(menuItemController, librarianJobHandlesMovies, "movie"));
        librarianMenuAction.put("7", new CheckedOutItemDetails(menuItemController, librarianJobHandlesBooks));
        librarianMenuAction.put("8", new CheckedOutItemDetails(menuItemController, librarianJobHandlesMovies));

        MenuController menuController = new MenuController(menuAction, view);

        App app = new App();

        view.printToConsole(Messages.WELCOME_MESSAGE);
        app.start(view, menuController, userValidation);

    }
}

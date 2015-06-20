package com.twu.biblioteca;

import com.twu.biblioteca.controller.MenuItemController;
import com.twu.biblioteca.models.UserValidation;
import com.twu.biblioteca.item.Book;
import com.twu.biblioteca.item.Movie;
import com.twu.biblioteca.menuAction.*;

import com.twu.biblioteca.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static com.twu.biblioteca.Messages.*;

public class EntryPoint {

    public static void main(String args[]) {
        boolean quit = false;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Item> booksList = new ArrayList<Item>();
        ArrayList<Item> moviesList = new ArrayList<Item>();
        ArrayList<Item> checkedOutBooks = new ArrayList<Item>();
        ArrayList<Item> checkedOutMovies = new ArrayList<Item>();
        ArrayList<Item> searchResult = new ArrayList<Item>();
        ArrayList<LibraryUser> libraryUsers = getLibraryUsers();

        ArrayList<UserProfile> userProfiles =new ArrayList<>();
        userProfiles.add(new UserProfile("b01-0002", "priya", "9988776655","priya@gmail.com"));


        View view = new View(scanner);

        HashMap<Item, String> checkedOutItemsAndUsers = new HashMap<>();
        HashMap<String, User> roleOfUser = new HashMap<>();

        getItemsList(booksList, moviesList, checkedOutBooks);
        LibrarianJob librarianJobHandlesBooks = new LibrarianJob(booksList, checkedOutBooks, checkedOutItemsAndUsers);
        LibrarianJob librarianJobHandlesMovies = new LibrarianJob(moviesList, checkedOutMovies, checkedOutItemsAndUsers);
        UserValidation userValidation = new UserValidation(libraryUsers);

        Books books = new Books(booksList);
        Movies movies = new Movies(moviesList);

        HashMap<String, MenuAction> menuAction = new HashMap<String, MenuAction>();
        MenuItemController menuItemController = getMemberHashMap(searchResult, userProfiles, view, librarianJobHandlesBooks, librarianJobHandlesMovies, books, movies, menuAction);


        HashMap<String, MenuAction> librarianMenuAction = getLibrarianHashMap(librarianJobHandlesBooks, librarianJobHandlesMovies, books, movies, menuItemController);


        HashMap<String, HashMap<String, MenuAction>> menu = getUserMenuActionHashMap(menuAction, librarianMenuAction);

        HashMap<String, String> printMenu = getUserMenuHashMap();

        App app = new App();

        view.printToConsole(WELCOME_MESSAGE);
        app.start(view, menu, userValidation, printMenu);

    }

    private static void getItemsList(ArrayList<Item> booksList, ArrayList<Item> moviesList, ArrayList<Item> checkedOutBooks) {
        booksList.add(new Book("oop concepts", "john", "2000"));
        booksList.add(new Book("The Lord Of Rings", "wilson", "2001"));
        checkedOutBooks.add(new Book("", "", ""));
        moviesList.add(new Movie("Avatar", "cameroon", "2011", "7"));
    }

    private static ArrayList<LibraryUser> getLibraryUsers() {
        ArrayList<LibraryUser> libraryUsers = new ArrayList<LibraryUser>();
        libraryUsers.add(new LibraryUser("b01-0002", "priya", "member"));
        libraryUsers.add(new LibraryUser("b01-0003", "sowmya", "librarian"));
        return libraryUsers;
    }

    private static HashMap<String, String> getUserMenuHashMap() {
        HashMap<String, String> printMenu = new HashMap<>();
        printMenu.put("librarian", LIBRARIAN_MENU);
        printMenu.put("member", MENU_LIST);
        return printMenu;
    }

    private static HashMap<String, HashMap<String, MenuAction>> getUserMenuActionHashMap(HashMap<String, MenuAction> menuAction, HashMap<String, MenuAction> librarianMenuAction) {
        HashMap<String, HashMap<String, MenuAction>> menu = new HashMap<>();
        menu.put("member", menuAction);
        menu.put("librarian", librarianMenuAction);
        return menu;
    }

    private static HashMap<String, MenuAction> getLibrarianHashMap(LibrarianJob librarianJobHandlesBooks, LibrarianJob librarianJobHandlesMovies, Books books, Movies movies, MenuItemController menuItemController) {
        HashMap<String, MenuAction> librarianMenuAction = new HashMap<>();
        librarianMenuAction.put("1", new ListBooks(menuItemController, books));
        librarianMenuAction.put("2", new CheckOut(menuItemController, librarianJobHandlesBooks, "book"));
        librarianMenuAction.put("3", new Return(menuItemController, librarianJobHandlesBooks, "book"));
        librarianMenuAction.put("4", new ListMovies(menuItemController, movies));
        librarianMenuAction.put("5", new CheckOut(menuItemController, librarianJobHandlesMovies, "movie"));
        librarianMenuAction.put("6", new Return(menuItemController, librarianJobHandlesMovies, "movie"));
        librarianMenuAction.put("7", new CheckedOutItemDetails(menuItemController, librarianJobHandlesBooks));
        librarianMenuAction.put("8", new CheckedOutItemDetails(menuItemController, librarianJobHandlesMovies));

        return librarianMenuAction;
    }

    private static MenuItemController getMemberHashMap(ArrayList<Item> searchResult, ArrayList<UserProfile> userProfiles, View view, LibrarianJob librarianJobHandlesBooks, LibrarianJob librarianJobHandlesMovies, Books books, Movies movies, HashMap<String, MenuAction> menuAction) {
        MenuItemController menuItemController = new MenuItemController(view, searchResult);
        menuAction.put("1", new ListBooks(menuItemController, books));
        menuAction.put("2", new CheckOut(menuItemController, librarianJobHandlesBooks, "book"));
        menuAction.put("3", new Return(menuItemController, librarianJobHandlesBooks, "book"));
        menuAction.put("4", new ListMovies(menuItemController, movies));
        menuAction.put("5", new CheckOut(menuItemController, librarianJobHandlesMovies, "movie"));
        menuAction.put("6", new Return(menuItemController, librarianJobHandlesMovies, "movie"));
        menuAction.put("7", new UserInformation(menuItemController,userProfiles));
        return menuItemController;
    }
}

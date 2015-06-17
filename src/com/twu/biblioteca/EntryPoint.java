package com.twu.biblioteca;

import com.twu.biblioteca.controller.MenuController;
import com.twu.biblioteca.controller.MenuItemController;
import com.twu.biblioteca.menuAction.*;

import com.twu.biblioteca.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EntryPoint {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> booksList = new ArrayList<Book>();
        ArrayList<Movie> moviesList = new ArrayList<Movie>();
        ArrayList<Book> checkedOutBooks = new ArrayList<Book>();
        ArrayList<Book> searchResult = new ArrayList<>();
        View view = new View(scanner);

        booksList.add(new Book("oop concepts", "john", "2000"));
        booksList.add(new Book("The Lord Of Rings", "wilson", "2001"));
        checkedOutBooks.add(new Book("", "", ""));

        moviesList.add(new Movie("Avatar", "cameroon", "2011", "7"));

        Librarian librarian = new Librarian(booksList, checkedOutBooks);
        BookSection bookSection = new BookSection(booksList);
        MoviesSection moviesSection = new MoviesSection(moviesList);
        HashMap<String, MenuAction> menuAction = new HashMap<String, MenuAction>();
        MenuItemController menuItemController = new MenuItemController(view, librarian);
        menuAction.put("1", new ListBooks(menuItemController, bookSection));
        menuAction.put("2", new CheckOutBook(menuItemController, searchResult));
        menuAction.put("3", new ReturnBook(menuItemController, searchResult));
        menuAction.put("4", new ListMovies(menuItemController, moviesSection));
        view.printToConsole(Messages.WELCOME_MESSAGE);
        MenuController menuController = new MenuController(menuAction, view);
        App app = new App();

        app.start(view, menuController);
    }
}

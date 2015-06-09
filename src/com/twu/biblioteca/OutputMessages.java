package com.twu.biblioteca;

//output message handler
public class OutputMessages {

    public void displayWelcomeMessage() {
        System.out.print("Welcome to Biblioteca App");
    }

    public void displayListOfBooks(Books books) { System.out.print(books.toString());}

    public void displayMenu() {
        System.out.print("Select option:\\n 1.ListBooks\\n 0.Quit");
    }

    public void displayInvalidOption() {
        System.out.print("Invalid option!! Select valid option");
    }
}
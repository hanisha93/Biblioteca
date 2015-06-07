package com.twu.biblioteca;

//output message handler
public class OutputMessages {

    public void displayWelcomeMessage() {
        System.out.print("Welcome to Biblioteca App");
    }
    public void displayListOfBooks(Books books) {
        System.out.println(books.toString());
    }
}

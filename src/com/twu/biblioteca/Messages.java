package com.twu.biblioteca;

public interface Messages {

    public final String WELCOME_MESSAGE = "Welcome to Biblioteca";
    public final String CHOOSE_OPTION = "Choose option";
    public final String INVALID_OPTION = "Choose a valid Option";
    public final String MENU_LIST = "1.ListBooks\n2.CheckOut\n3.ReturnBook\n0.quit";
    public final String CHECKOUT_BOOK = "Enter book to checkout";
    public final String SUCCESSFUL_CHECKOUT = "Thanq you! Enjoy the book";
    public final String CHECKOUT_FAIL = "That book is not available";
    public final String RETURN_BOOK = "Enter book to return";
    public final String RETURN_FAIL = "That is not a valid book to return";
    public final String SUCCESSFUL_RETURN = "Thank you for returning the book";
}

package com.twu.biblioteca;

public interface Messages {

    public final String WELCOME_MESSAGE = "Welcome to Biblioteca";
    public final String CHOOSE_OPTION = "Choose option";
    public final String INVALID_OPTION = "Choose a valid Option";
    public final String MENU_LIST = "1.ListBooks\n2.CheckOut\n3.Return\n4.ListMovies\n5.CheckOutMovie\n6.ReturnMovie\n0.quit";
    public final String SUCCESSFUL_CHECKOUT = "Thanq you! Enjoy the ";
    public final String CHECKOUT_FAIL = " is not available";
    public final String RETURN_FAIL = "That is not a valid ";
    public final String SUCCESSFUL_RETURN = "Thank you for returning the ";
    public final String ENTER_LIBID = "Enter the library id";
    public final String ENTER_PWD = "Enter password";
    public final String LOGIN_SUCCESS = "Welcome user";
    public final String LOGIN_FAIL = "Invalid username or password";
}

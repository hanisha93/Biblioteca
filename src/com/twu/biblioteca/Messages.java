package com.twu.biblioteca;

public interface Messages {

    public final String WELCOME_MESSAGE = "\n\n************* WELCOME TO BIBLIOTECA **************\n\n";
    public final String CHOOSE_OPTION = "     Choose option\n     ";
    public final String INVALID_OPTION = "     Choose a valid Option\n     ";
    public final String MENU_LIST = "\n\n     1.ListBooks\n     2.CheckOut\n     3.Return\n     4.ListMovies\n     5.CheckOutMovie" +
            "\n     6.ReturnMovie\n     7.YourProfile\n     0.LogOut\n"     ;
    public final String LIBRARIAN_MENU = " \n\n    1.ListBooks\n     2.CheckOut\n     3.Return\n     4.ListMovies\n     5.CheckOutMovie\n     6.ReturnMovie" +
            "\n     7.CheckedOutBooks\n     8.CheckedOutMovies\n     9.Quit\n     0.LogOut";
    public final String SUCCESSFUL_CHECKOUT = "     Thanq you! Enjoy the ";
    public final String CHECKOUT_FAIL = " is not available\n";
    public final String RETURN_FAIL = "    That is not a valid ";
    public final String SUCCESSFUL_RETURN = "     Thank you for returning the ";
    public final String ENTER_LIBID = "     Enter the library id\n\n     ";
    public final String ENTER_PWD = "     Enter password\n\n     ";
    public final String LOGIN_SUCCESS = "      Welcome user";
    public final String LOGIN_FAIL = "\n     Invalid username or password\n     ";
}

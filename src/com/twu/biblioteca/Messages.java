package com.twu.biblioteca;

public interface Messages {

    public final String WELCOME_MESSAGE = "\n\n************* WELCOME TO BIBLIOTECA **************\n\n";
    public final String CHOOSE_OPTION = "     Choose option\n     ";
    public final String INVALID_OPTION = "     Choose a valid Option\n     ";
    public final String COMMON_MENU = "\n     1.ListBooks\n     2.ListMovies\n     3.LogIn to CheckOutOption Or ReturnOption an Item\n";
    public final String MENU_LIST = "\n\n     1.CheckOutBook\n     2.ReturnBook\n     3.CheckOutMovie" +
            "\n     4.ReturnMovie\n     5.YourProfile\n     0.LogOut\n"     ;
    public final String LIBRARIAN_MENU = " \n\n     1.CheckOutBook\n     2.ReturnBook\n     3.CheckOutMovie\n     4.ReturnMovie" +
            "\n     5.CheckedOutBooksDetails\n     6.CheckedOutMoviesDetails\n     7.Quit\n     0.LogOut\n";
    public final String SUCCESSFUL_CHECKOUT = "     Thanq you! Enjoy the ";
    public final String CHECKOUT_FAIL = " is not available\n";
    public final String RETURN_FAIL = "    That is not a valid ";
    public final String SUCCESSFUL_RETURN = "     Thank you for returning the ";
    public final String ENTER_LIBID = "     Enter the library id\n\n     ";
    public final String ENTER_PWD = "     Enter password\n\n     ";
    public final String LOGIN_SUCCESS = "      Welcome user";
    public final String LOGIN_FAIL = "\n     Invalid username or password\n     ";
}

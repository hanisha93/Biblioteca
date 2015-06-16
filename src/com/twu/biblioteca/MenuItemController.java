package com.twu.biblioteca;

import java.util.ArrayList;

import static com.twu.biblioteca.Messages.*;

//controlling all items in menu
public class MenuItemController {
    private View view;
    private Library library;
    public MenuItemController(View view,Library library) {
        this.view = view;
        this.library = library;
    }

    public void listBooks(Library library) {
        view.printToConsole(library.toString());
    }

    public void invalidOption() {
        view.printToConsole(INVALID_OPTION);
    }

    public void checkOut(ArrayList<Book> result) {
        view.printToConsole(CHECKOUT_BOOK);
        String title = view.readInput();
        library.searchBook(title, result);
        if(result.isEmpty()) {
            view.printToConsole(CHECKOUT_FAIL);
        }
        else {
            library.doCheckout(result.get(0));
            view.printToConsole(SUCCESSFUL_CHECKOUT);
        }
    }


    private Book getBook(String message) {
        view.printToConsole(message);
        return view.readBook();
    }

    public void returnBook(ArrayList<Book> checkedOutBooks, ArrayList<Book> booksList) {
        int i;
        Book returnBook = getBook(RETURN_BOOK);
        for (i = 0; i < checkedOutBooks.size(); i++) {
            if(returnBook.equals(checkedOutBooks.get(i))) {
                returnBook = getReturnBook(checkedOutBooks, booksList, i);
                break;
            }
        }
        if (i == checkedOutBooks.size()) {
            view.printToConsole(RETURN_FAIL);
        }
        checkedOutBooks.remove(returnBook);
    }

    private Book getReturnBook(ArrayList<Book> checkedOutBooks, ArrayList<Book> booksList, int i) {
        Book returnBook;
        returnBook = checkedOutBooks.get(i);
        view.printToConsole(SUCCESSFUL_RETURN);
        booksList.add(checkedOutBooks.get(i));
        return returnBook;
    }

}

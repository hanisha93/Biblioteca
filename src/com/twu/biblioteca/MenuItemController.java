package com.twu.biblioteca;

import java.util.ArrayList;

import static com.twu.biblioteca.Messages.*;

//controlling all items in menu
public class MenuItemController {
    private View view;

    public MenuItemController(View view) {
        this.view = view;
    }

    public void listBooks(Library library) {
        view.printToConsole(library.toString());
    }

    public void invalidOption() {
        view.printToConsole(INVALID_OPTION);
    }

    public void checkOut(ArrayList<Book> checkedOutBooks, ArrayList<Book> booksList) {
        int i;
        Book checkOutBook = getBook(CHECKOUT_BOOK);
        for (i = 0; i < booksList.size(); i++) {
            if(checkOutBook.equals(booksList.get(i))) {
                checkOutBook = getCheckOutBook(checkedOutBooks, booksList, i);
                break;
            }
        }
        if (i == booksList.size()) {
            view.printToConsole(CHECKOUT_FAIL);
        }
        booksList.remove(checkOutBook);
    }


    private Book getBook(String message) {
        view.printToConsole(message);
        return view.readBook();
    }

    private Book getCheckOutBook(ArrayList<Book> checkedOutBooks, ArrayList<Book> booksList, int i) {
        Book checkOutBook;
        checkedOutBooks.add(booksList.get(i));
        view.printToConsole(SUCCESSFUL_CHECKOUT);
        checkOutBook  = booksList.get(i);
        return checkOutBook;
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

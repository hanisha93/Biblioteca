package com.twu.biblioteca;

import org.omg.PortableInterceptor.SUCCESSFUL;

import java.util.ArrayList;

import static com.twu.biblioteca.Messages.*;

//controlling all items in menu
public class MenuItemController {
    private View view;

    public MenuItemController(View view) {
        this.view = view;
    }

    public void listBooks(Books books) {
        view.printToConsole(books.toString());
    }

    public void invalidOption() {
        view.printToConsole(INVALID_OPTION);
    }

    public void checkOut(ArrayList<Book> checkedOutBooks, ArrayList<Book> booksList) {
        Book checkOutBook = getBook(CHECKOUT_BOOK);
        int i;
        for (i = 0; i < booksList.size(); i++) {
            if (checkOutBook(checkedOutBooks, booksList, i, checkOutBook)) break;
        }
        checkOutFail(booksList, i);

    }
    public void returnBook(ArrayList<Book> checkedOutBooks, ArrayList<Book> booksList) {
        Book returnBook = getBook(RETURN_BOOK);
        

    }

    private Book getBook(String msg) {
        int i = 0;
        view.printToConsole(msg);
        return view.readBook();
    }

    private void checkOutFail(ArrayList<Book> booksList, int i) {
        if (i == booksList.size()) {
            view.printToConsole(CHECKOUT_FAIL);
        }
    }

    private boolean checkOutBook(ArrayList<Book> checkedOutBooks, ArrayList<Book> booksList, int i, Book checkOutBook) {
        if (checkOutBook.equals(booksList.get(i))) {
            checkedOutBooks.add(booksList.get(i));
            view.printToConsole(SUCCESSFUL_CHECKOUT);
            booksList.remove(booksList.get(i));
            return true;
        }
        return false;
    }
}

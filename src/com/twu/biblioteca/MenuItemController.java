package com.twu.biblioteca;

import org.omg.PortableInterceptor.SUCCESSFUL;

import java.util.ArrayList;
import java.util.Iterator;

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
        int i;
        view.printToConsole(CHECKOUT_BOOK);
        Book checkOutBook  = view.readBook();
        for (i = 0; i < booksList.size(); i++) {
            if(checkOutBook.equals(booksList.get(i))) {
                checkedOutBooks.add(booksList.get(i));
                view.printToConsole(SUCCESSFUL_CHECKOUT);
                checkOutBook  = booksList.get(i);
                break;
            }
        }
        if (i == booksList.size()) {
            view.printToConsole(CHECKOUT_FAIL);
        }
        booksList.remove(checkOutBook);

    }
    public void returnBook(ArrayList<Book> checkedOutBooks, ArrayList<Book> booksList) {
        view.printToConsole(RETURN_BOOK);
        Book returnBook  = view.readBook();
        int i;
        for (i = 0; i < checkedOutBooks.size(); i++) {
            if(returnBook.equals(checkedOutBooks.get(i))) {
                returnBook = checkedOutBooks.get(i);
                view.printToConsole(SUCCESSFUL_RETURN);
                booksList.add(checkedOutBooks.get(i));
                break;
            }
        }
        checkedOutBooks.remove(returnBook);
    }

}

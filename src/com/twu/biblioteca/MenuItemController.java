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
        int i = 0;
        view.printToConsole(CHECKOUT_BOOK);
        Book checkOutBook = view.readBook();
        for (i = 0; i < booksList.size(); i++) {
            if (checkOutBook.equals(booksList.get(i))) {
                checkedOutBooks.add(booksList.get(i));
                view.printToConsole(SUCCESSFUL_CHECKOUT);
                booksList.remove(booksList.get(i));
                break;
            }
        }
        if (i == booksList.size()) {
            view.printToConsole(CHECKOUT_FAIL);
        }

    }
}

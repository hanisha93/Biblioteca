package com.twu.biblioteca.models;

import com.twu.biblioteca.models.Book;

import java.util.ArrayList;

import static com.twu.biblioteca.Messages.*;

public class Librarian {

    private ArrayList<Book> listOfBooks;
    private ArrayList<Book> checkedOutBooks;

    public Librarian(ArrayList<Book> listOfBooks, ArrayList<Book> checkedOutBooks) {
        this.listOfBooks = listOfBooks;
        this.checkedOutBooks = checkedOutBooks;
    }

    public ArrayList<Book> searchBook(String title, ArrayList<Book> result) {
        for (Book book : listOfBooks) {
            if (book.matchBook(title)) {
                result.add(book);
                break;
            }
        }
        return result;
    }

    public ArrayList<Book> searchCheckedOutList(String title, ArrayList<Book> result) {
        for (Book book : checkedOutBooks) {
            if (book.matchBook(title)) {
                result.add(book);
                break;
            }
        }
        return result;
    }

    public String doCheckout(ArrayList<Book> result) {
        for (Book book : result) {
            listOfBooks.remove(book);
            checkedOutBooks.add(book);
            return SUCCESSFUL_CHECKOUT;
        }
        return CHECKOUT_FAIL;
    }

    public String returnBook(ArrayList<Book> result) {
        for (Book book : result) {
            listOfBooks.add(book);
            checkedOutBooks.remove(book);
            return SUCCESSFUL_RETURN;
        }
        return RETURN_FAIL;
    }

}
package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> listOfBooks;
    private ArrayList<Book> checkedOutBooks;

    public Library(ArrayList<Book> listOfBooks , ArrayList<Book> checkedOutBooks) {
        this.listOfBooks = listOfBooks;
        this.checkedOutBooks = checkedOutBooks;
    }

    @Override
    public String toString() {
        String booksList = "";
        for (Book book : listOfBooks) {
            booksList = booksList + "" + book.toString()+"\n";
        }
        return booksList;
    }

    public ArrayList<Book> searchBook(String title, ArrayList<Book> result) {
        for(Book eachBook : listOfBooks)
        if(eachBook.matchBook(title)) {
            result.add(eachBook);
        }
        return result;
    }

    public ArrayList<Book> searchCheckedOutList(String title, ArrayList<Book> result) {
        for (Book eachBook : checkedOutBooks)
            if (eachBook.matchBook(title)) {
                result.add(eachBook);
            }
        return result;
    }

    public void doCheckout(Book book) {
        listOfBooks.remove(book);
        checkedOutBooks.add(book);
    }

    public void returnBook(Book book) {
        listOfBooks.add(book);
        checkedOutBooks.remove(book);
    }

}
package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static com.twu.biblioteca.Messages.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MenuItemControllerTest {

    @Test
    public void specToCheckListBooksMenuItem() {

        View view = mock(View.class);
        Books books = mock(Books.class);
        MenuItemController menuItemController = new MenuItemController(view);

        menuItemController.listBooks(books);

        verify(view, Mockito.times(1)).printToConsole(books.toString());
    }

    @Test
    public void specToCheckInvalidOption() {

        View view = mock(View.class);
        Books books = mock(Books.class);
        MenuItemController menuItemController = new MenuItemController(view);

        menuItemController.invalidOption();

        verify(view, Mockito.times(1)).printToConsole(INVALID_OPTION);
    }

    @Test
    public void specToCheckCheckOutBookMenuItemDisplayingCheckOutMessage() {

        View view = mock(View.class);
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        ArrayList<Book> checkedOutList = new ArrayList<Book>();
        MenuItemController menuItemController = new MenuItemController(view);
        menuItemController.checkOut(checkedOutList, listOfBooks);

        verify(view, Mockito.times(1)).printToConsole(CHECKOUT_BOOK);
    }

    @Test
    public void specToTestCheckOutBookMenuItemTakingBookToBeCheckedOut() {

        View view = mock(View.class);
        when(view.readBook()).thenReturn(new Book("java", "john", "2001"));
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("java", "john", "2000"));
        ArrayList<Book> checkedOut = new ArrayList<Book>();
        checkedOut.add(new Book("java", "john", "2000"));
        MenuItemController menuItemController = new MenuItemController(view);
        menuItemController.checkOut(checkedOut, books);

        verify(view, Mockito.times(1)).readBook();

    }

    @Test
    public void specToCheckCheckOutBookMenuItemAddingBookToCheckedOutList() {

        View view = mock(View.class);
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        listOfBooks.add(new Book("java", "john", "2000"));
        when(view.readBook()).thenReturn(new Book("java", "", ""));
        ArrayList<Book> checkedList = new ArrayList<Book>();
        MenuItemController menuItemController = new MenuItemController(view);
        menuItemController.checkOut(checkedList, listOfBooks);

        ArrayList<Book> expectedListOne = new ArrayList<Book>();
        expectedListOne.add(new Book("java", "", ""));

        assertThat(checkedList, is(expectedListOne));
    }

    @Test
    public void specToTestCheckedOutBookIsRemovedFromBooksList() {

        View view = mock(View.class);
        ArrayList<Book> list = new ArrayList<Book>();
        list.add(new Book("java", "john", "2000"));
        list.add(new Book("oop", "wilson", "2001"));
        when(view.readBook()).thenReturn(new Book("java", "", ""));
        ArrayList<Book> checkedOutList = new ArrayList<Book>();
        MenuItemController menuItemController = new MenuItemController(view);
        menuItemController.checkOut(checkedOutList, list);

        ArrayList<Book> expectedList = new ArrayList<Book>();
        expectedList.add(new Book("oop", "wilson", "2001"));

        assertThat(list, is(expectedList));
    }

    @Test
    public void specToTestCheckOutBookIsNotInBooksList() {

        View view = mock(View.class);
        ArrayList<Book> list = new ArrayList<Book>();
        list.add(new Book("java", "john", "2000"));
        list.add(new Book("oop", "wilson", "2001"));
        when(view.readBook()).thenReturn(new Book("oops", "", ""));
        ArrayList<Book> checkedOutList = new ArrayList<Book>();
        MenuItemController menuItemController = new MenuItemController(view);
        menuItemController.checkOut(checkedOutList, list);

        ArrayList<Book> expectedList = new ArrayList<Book>();

        assertThat(checkedOutList, is(expectedList));
    }

    @Test
    public void specToTestCheckOutBookIsNotInBooksListPrintsMessageOnConsole() {

        View view = mock(View.class);
        ArrayList<Book> list = new ArrayList<Book>();
        list.add(new Book("java", "john", "2000"));
        list.add(new Book("oop", "wilson", "2001"));
        when(view.readBook()).thenReturn(new Book("oops", "", ""));
        ArrayList<Book> checkedOutList = new ArrayList<Book>();
        MenuItemController menuItemController = new MenuItemController(view);
        menuItemController.checkOut(checkedOutList, list);

        ArrayList<Book> expectedList = new ArrayList<Book>();

        verify(view, Mockito.times(1)).printToConsole(CHECKOUT_FAIL);
    }

    @Test
    public void specToTestRetutnBookMenuItemDisplayingReturnBookMessage() {

        View view = mock(View.class);
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        ArrayList<Book> checkedOutList = new ArrayList<Book>();
        MenuItemController menuItemController = new MenuItemController(view);
        menuItemController.returnBook(checkedOutList, listOfBooks);

        verify(view, Mockito.times(1)).printToConsole(RETURN_BOOK);
    }

    @Test
    public void specToTestReturnBookMenuItemTakingBookToBeReturned() {

        View view = mock(View.class);
        when(view.readBook()).thenReturn(new Book("java", "john", "2001"));
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("java", "john", "2000"));
        ArrayList<Book> checkedOut = new ArrayList<Book>();
        checkedOut.add(new Book("java", "john", "2000"));
        MenuItemController menuItemController = new MenuItemController(view);
        menuItemController.returnBook(checkedOut, books);

        verify(view).readBook();

    }

}
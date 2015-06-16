package com.twu.biblioteca;

import org.junit.Test;

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
        Library library = mock(Library.class);
        MenuItemController menuItemController = new MenuItemController(view, library);

        menuItemController.listBooks(library);

        verify(view).printToConsole(library.toString());
    }

    @Test
    public void specToCheckInvalidOption() {

        View view = mock(View.class);
        Library library = mock(Library.class);
        MenuItemController menuItemController = new MenuItemController(view, library);

        menuItemController.invalidOption();

        verify(view).printToConsole(INVALID_OPTION);
    }

    @Test
    public void specToCheckCheckOutBookMenuItemDisplayingCheckOutMessage() {

        View view = mock(View.class);
        Library library = mock(Library.class);
        ArrayList<Book> searchResult = new ArrayList<Book>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, library);
        menuItemController.checkOut(searchResult);

        verify(view).printToConsole(CHECKOUT_BOOK);
    }

    @Test
    public void specToTestCheckOutBookMenuItemTakingBookToBeCheckedOut() {

        View view = mock(View.class);
        Library library = mock(Library.class);
        ArrayList<Book> searchResult = new ArrayList<Book>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, library);
        menuItemController.checkOut(searchResult);

        verify(view).readInput();

    }

    @Test
    public void specToTestCheckoutOptionSearchesMatchingBookInLibrary() {

        View view = mock(View.class);
        Library library = mock(Library.class);
        ArrayList<Book> searchResult = new ArrayList<Book>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, library);
        menuItemController.checkOut(searchResult);

        verify(library).searchBook("java", searchResult);

    }

    @Test
    public void specToTestThereAreNoBooksThatMatchesBooksInLibary() {

        View view = mock(View.class);
        Library library = mock(Library.class);
        ArrayList<Book> searchResult = new ArrayList<Book>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, library);
        menuItemController.checkOut(searchResult);

        verify(view).printToConsole(CHECKOUT_FAIL);
    }

    @Test
    public void specToTestWhenThereAreBooksThatMatchesBooksInLibary() {

        View view = mock(View.class);
        Library library = mock(Library.class);
        ArrayList<Book> searchResult = new ArrayList<Book>();
        searchResult.add(new Book("java", "john" ,"2001"));
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, library);
        menuItemController.checkOut(searchResult);

        verify(view).printToConsole(SUCCESSFUL_CHECKOUT);
    }

    @Test
    public void specToTestWhenThereAreBooksThatMatchesBooksInLibaryPerformsCheckout() {

        View view = mock(View.class);
        Library library = mock(Library.class);
        ArrayList<Book> searchResult = new ArrayList<Book>();
        searchResult.add(new Book("java", "john" ,"2001"));
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, library);
        menuItemController.checkOut(searchResult);

        verify(library).doCheckout(searchResult.get(0));
    }

    /*@Test
    public void specToTestCheckOutBookIsNotInBooksListPrintsFailureMessageOnConsole() {

        View view = mock(View.class);
        Library library = mock(Library.class);
        ArrayList<Book> list = new ArrayList<Book>();
        list.add(new Book("java", "john", "2000"));
        list.add(new Book("oop", "wilson", "2001"));
        when(view.readBook()).thenReturn(new Book("oops", "", ""));
        ArrayList<Book> checkedOutList = new ArrayList<Book>();
        MenuItemController menuItemController = new MenuItemController(view);
        menuItemController.checkOut(checkedOutList, list);

        verify(view).printToConsole(CHECKOUT_FAIL);
    }

    @Test
    public void specToTestRetutnBookMenuItemDisplayingReturnBookMessage() {

        View view = mock(View.class);
        Library library = mock(Library.class);
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        ArrayList<Book> checkedOutList = new ArrayList<Book>();
        MenuItemController menuItemController = new MenuItemController(view);
        menuItemController.returnBook(checkedOutList, listOfBooks);

        verify(view).printToConsole(RETURN_BOOK);
    }

    @Test
    public void specToTestReturnBookMenuItemTakingBookToBeReturned() {

        View view = mock(View.class);
        Library library = mock(Library.class);
        when(view.readBook()).thenReturn(new Book("java", "john", "2001"));
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("java", "john", "2000"));
        ArrayList<Book> checkedOut = new ArrayList<Book>();
        checkedOut.add(new Book("java", "john", "2000"));
        MenuItemController menuItemController = new MenuItemController(view);
        menuItemController.returnBook(checkedOut, books);

        verify(view).readBook();

    }

    @Test
    public void specToTestReturnBookMenuItemAddingReturnedBookToBooksList() {

        View view = mock(View.class);
        Library library = mock(Library.class);
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        when(view.readBook()).thenReturn(new Book("java", "", ""));
        ArrayList<Book> checkedList = new ArrayList<Book>();
        checkedList.add(new Book("java", "jahn", "2004"));
        MenuItemController menuItemController = new MenuItemController(view);
        menuItemController.returnBook(checkedList, listOfBooks);

        ArrayList<Book> expectedListOne = new ArrayList<Book>();
        expectedListOne.add(new Book("java", "jahn", "2004"));

        assertThat(listOfBooks, is(expectedListOne));
    }

    @Test
    public void specToTestReturnedBookIsRemovedFromCheckedOutList() {

        View view = mock(View.class);
        Library library = mock(Library.class);
        when(view.readBook()).thenReturn(new Book("java", "john", "2000"));
        ArrayList<Book> list = new ArrayList<Book>();
        list.add(new Book("oop", "wilson", "2001"));
        ArrayList<Book> checkedOutList = new ArrayList<Book>();
        checkedOutList.add(new Book("java", "john", "2000"));
        MenuItemController menuItemController = new MenuItemController(view);
        menuItemController.returnBook(checkedOutList, list);

        ArrayList<Book> expectedList = new ArrayList<Book>();

        assertThat(checkedOutList, is(expectedList));
    }

    @Test
    public void specToTestReturnedBookIsAValidBookPrintsSuccessfulMessageOnConsole() {

        View view = mock(View.class);
        Library library = mock(Library.class);
        ArrayList<Book> list = new ArrayList<Book>();
        list.add(new Book("java", "john", "2000"));
        when(view.readBook()).thenReturn(new Book("oop", "", ""));
        ArrayList<Book> checkedOutList = new ArrayList<Book>();
        checkedOutList.add(new Book("oop", "wilson", "2001"));
        MenuItemController menuItemController = new MenuItemController(view);
        menuItemController.returnBook(checkedOutList, list);

        verify(view).printToConsole(SUCCESSFUL_RETURN);
    }

    @Test
    public void specToTestReturnedBookIsNotAValidBookPrintsFailureMessageOnConsole() {

        View view = mock(View.class);
        Library library = mock(Library.class);
        ArrayList<Book> list = new ArrayList<Book>();
        list.add(new Book("java", "john", "2000"));
        when(view.readBook()).thenReturn(new Book("oops", "", ""));
        ArrayList<Book> checkedOutList = new ArrayList<Book>();
        checkedOutList.add(new Book("oop", "wilson", "2001"));
        MenuItemController menuItemController = new MenuItemController(view);
        menuItemController.returnBook(checkedOutList, list);

        verify(view).printToConsole(RETURN_FAIL);
    }*/

}
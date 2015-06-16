package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static com.twu.biblioteca.Messages.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

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
    public void specToTestCheckOutBookMenuItemDisplayingCheckOutMessages() {
        View view = mock(View.class);
        Library library = mock(Library.class);
        ArrayList<Book> searchResult = new ArrayList<Book>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, library);
        menuItemController.checkOut(searchResult);

        verify(view, times(2)).printToConsole(anyString());
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
    public void specToTestWhenThereAreBooksThatMatchesBooksInLibaryPerformsCheckout() {
        View view = mock(View.class);
        Library library = mock(Library.class);
        ArrayList<Book> searchResult = new ArrayList<Book>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, library);
        menuItemController.checkOut(searchResult);

        verify(library).doCheckout(searchResult);
    }

    @Test
    public void specToTestReturnBookMenuItemDisplayingReturnMessages() {
        View view = mock(View.class);
        Library library = mock(Library.class);
        ArrayList<Book> searchResult = new ArrayList<Book>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, library);
        menuItemController.returnBook(searchResult);

        verify(view, times(2)).printToConsole(anyString());
    }

    @Test
    public void specToTestReturnBookMenuItemTakingBookToBeReturned() {
        View view = mock(View.class);
        Library library = mock(Library.class);
        ArrayList<Book> searchResult = new ArrayList<Book>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, library);
        menuItemController.returnBook(searchResult);

        verify(view).readInput();

    }

    @Test
    public void specToTestReturnOptionSearchesMatchingBookInCheckedOutList() {
        View view = mock(View.class);
        Library library = mock(Library.class);
        ArrayList<Book> searchResult = new ArrayList<Book>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, library);
        menuItemController.returnBook(searchResult);

        verify(library).searchCheckedOutList("java", searchResult);

    }

    @Test
    public void specToTestWhenThereAreBooksThatMatchesBookInCheckedOutListTakeReturnedBook() {
        View view = mock(View.class);
        Library library = mock(Library.class);
        ArrayList<Book> searchResult = new ArrayList<Book>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, library);
        menuItemController.returnBook(searchResult);

        verify(library).returnBook(searchResult);
    }

}
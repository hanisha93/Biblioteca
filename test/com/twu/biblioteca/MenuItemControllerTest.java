package com.twu.biblioteca;

import com.twu.biblioteca.controller.MenuItemController;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Librarian;
import com.twu.biblioteca.models.BookSection;
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
        BookSection bookSection = mock(BookSection.class);
        Librarian librarian = mock(Librarian.class);
        MenuItemController menuItemController = new MenuItemController(view, librarian);

        menuItemController.listBooks(bookSection);

        verify(view).printToConsole(bookSection.toString());
    }

    @Test
    public void specToCheckInvalidOption() {
        View view = mock(View.class);
        Librarian librarian = mock(Librarian.class);
        MenuItemController menuItemController = new MenuItemController(view, librarian);

        menuItemController.invalidOption();

        verify(view).printToConsole(INVALID_OPTION);
    }

    @Test
    public void specToTestCheckOutBookMenuItemDisplayingCheckOutMessages() {
        View view = mock(View.class);
        Librarian librarian = mock(Librarian.class);
        ArrayList<Book> searchResult = new ArrayList<Book>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, librarian);
        menuItemController.checkOut(searchResult);

        verify(view, times(2)).printToConsole(anyString());
    }

    @Test
    public void specToTestCheckOutBookMenuItemTakingBookToBeCheckedOut() {
        View view = mock(View.class);
        Librarian librarian = mock(Librarian.class);
        ArrayList<Book> searchResult = new ArrayList<Book>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, librarian);
        menuItemController.checkOut(searchResult);

        verify(view).readInput();

    }

    @Test
    public void specToTestCheckoutOptionSearchesMatchingBookInLibrary() {
        View view = mock(View.class);
        Librarian librarian = mock(Librarian.class);
        ArrayList<Book> searchResult = new ArrayList<Book>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, librarian);
        menuItemController.checkOut(searchResult);

        verify(librarian).searchBook("java", searchResult);

    }

    @Test
    public void specToTestWhenThereAreBooksThatMatchesBooksInLibaryPerformsCheckout() {
        View view = mock(View.class);
        Librarian librarian = mock(Librarian.class);
        ArrayList<Book> searchResult = new ArrayList<Book>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, librarian);
        menuItemController.checkOut(searchResult);

        verify(librarian).doCheckout(searchResult);
    }

    @Test
    public void specToTestReturnBookMenuItemDisplayingReturnMessages() {
        View view = mock(View.class);
        Librarian librarian = mock(Librarian.class);
        ArrayList<Book> searchResult = new ArrayList<Book>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, librarian);
        menuItemController.returnBook(searchResult);

        verify(view, times(2)).printToConsole(anyString());
    }

    @Test
    public void specToTestReturnBookMenuItemTakingBookToBeReturned() {
        View view = mock(View.class);
        Librarian librarian = mock(Librarian.class);
        ArrayList<Book> searchResult = new ArrayList<Book>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, librarian);
        menuItemController.returnBook(searchResult);

        verify(view).readInput();

    }

    @Test
    public void specToTestReturnOptionSearchesMatchingBookInCheckedOutList() {
        View view = mock(View.class);
        Librarian librarian = mock(Librarian.class);
        ArrayList<Book> searchResult = new ArrayList<Book>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, librarian);
        menuItemController.returnBook(searchResult);

        verify(librarian).searchCheckedOutList("java", searchResult);

    }

    @Test
    public void specToTestWhenThereAreBooksThatMatchesBookInCheckedOutListTakeReturnedBook() {
        View view = mock(View.class);
        Librarian librarian = mock(Librarian.class);
        ArrayList<Book> searchResult = new ArrayList<Book>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, librarian);
        menuItemController.returnBook(searchResult);

        verify(librarian).returnBook(searchResult);
    }

}
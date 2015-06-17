package com.twu.biblioteca.controller;

import com.twu.biblioteca.Item;
import com.twu.biblioteca.View;
import com.twu.biblioteca.controller.MenuItemController;
import com.twu.biblioteca.item.Book;
import com.twu.biblioteca.models.Librarian;
import com.twu.biblioteca.models.Books;
import com.twu.biblioteca.models.Movies;
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
        Books books = mock(Books.class);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        MenuItemController menuItemController = new MenuItemController(view, searchResult);

        menuItemController.listBooks(books);

        verify(view).printToConsole(books.toString());
    }

    @Test
    public void specToCheckInvalidOption() {
        View view = mock(View.class);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        MenuItemController menuItemController = new MenuItemController(view, searchResult);

        menuItemController.invalidOption();

        verify(view).printToConsole(INVALID_OPTION);
    }

    @Test
    public void specToTestCheckOutBookMenuItemDisplayingCheckOutMessages() {
        View view = mock(View.class);
        Librarian librarian = mock(Librarian.class);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, searchResult);
        menuItemController.checkOut(librarian);

        verify(view, times(2)).printToConsole(anyString());
    }

    @Test
    public void specToTestCheckOutBookMenuItemTakingBookToBeCheckedOut() {
        View view = mock(View.class);
        Librarian librarian = mock(Librarian.class);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, searchResult);
        menuItemController.checkOut(librarian);

        verify(view).readInput();

    }

    @Test
    public void specToTestCheckoutOptionSearchesMatchingBookInLibrary() {
        View view = mock(View.class);
        Librarian librarian = mock(Librarian.class);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, searchResult);
        menuItemController.checkOut(librarian);

        verify(librarian).searchBook("java", searchResult);

    }

    @Test
    public void specToTestWhenThereAreBooksThatMatchesBooksInLibaryPerformsCheckout() {
        View view = mock(View.class);
        Librarian librarian = mock(Librarian.class);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, searchResult);
        menuItemController.checkOut(librarian);

        verify(librarian).doCheckout(searchResult);
    }

    @Test
    public void specToTestReturnBookMenuItemDisplayingReturnMessages() {
        View view = mock(View.class);
        Librarian librarian = mock(Librarian.class);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, searchResult);
        menuItemController.returnBook(librarian);

        verify(view, times(2)).printToConsole(anyString());
    }

    @Test
    public void specToTestReturnBookMenuItemTakingBookToBeReturned() {
        View view = mock(View.class);
        Librarian librarian = mock(Librarian.class);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, searchResult);
        menuItemController.returnBook(librarian);

        verify(view).readInput();

    }

    @Test
    public void specToTestReturnOptionSearchesMatchingBookInCheckedOutList() {
        View view = mock(View.class);
        Librarian librarian = mock(Librarian.class);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, searchResult);
        menuItemController.returnBook(librarian);

        verify(librarian).searchCheckedOutList("java", searchResult);

    }

    @Test
    public void specToTestWhenThereAreBooksThatMatchesBookInCheckedOutListTakeReturnedBook() {
        View view = mock(View.class);
        Librarian librarian = mock(Librarian.class);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, searchResult);
        menuItemController.returnBook(librarian);

        verify(librarian).returnBook(searchResult);
    }

    @Test
    public void specToCheckListMoviesMenuItem() {
        View view = mock(View.class);
        Movies movies = mock(Movies.class);
        Librarian librarian = mock(Librarian.class);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        MenuItemController menuItemController = new MenuItemController(view,searchResult);

        menuItemController.listMovies(movies);

        verify(view).printToConsole(movies.toString());
    }
}
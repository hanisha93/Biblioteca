package com.twu.biblioteca.controller;

import com.twu.biblioteca.Item;
import com.twu.biblioteca.View;
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
    public void specToTestCheckOutItemOptionDisplayingCheckOutMessages() {
        View view = mock(View.class);
        Librarian librarian = mock(Librarian.class);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, searchResult);
        menuItemController.checkOut(librarian, "book", "b01-001");

        verify(view, times(2)).printToConsole(anyString());
    }

    @Test
    public void specToTestCheckOutItemTakingitemTitleToBeCheckedOut() {
        View view = mock(View.class);
        Librarian librarian = mock(Librarian.class);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, searchResult);
        menuItemController.checkOut(librarian, "movie", "b01-001");

        verify(view).readInput();

    }

    @Test
    public void specToTestCheckoutItemOptionSearchesMatchingItemInLibrary() {
        View view = mock(View.class);
        Librarian librarian = mock(Librarian.class);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, searchResult);
        menuItemController.checkOut(librarian, "book", "b01-0001");

        verify(librarian).searchItem("java", searchResult);

    }

    @Test
    public void specToTestAfterGettingSearchResultCallDoCheckoutInLibrarian() {
        View view = mock(View.class);
        Librarian librarian = mock(Librarian.class);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, searchResult);
        menuItemController.checkOut(librarian, "movie", "b01-0001");

        verify(librarian).doCheckout(searchResult, "movie", "b01-0001");
    }

    @Test
    public void specToTestReturnItemOptionDisplayingReturnMessages() {
        View view = mock(View.class);
        Librarian librarian = mock(Librarian.class);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, searchResult);
        menuItemController.returnBook(librarian, "book", "b01-001");

        verify(view, times(2)).printToConsole(anyString());
    }

    @Test
    public void specToTestReturnItemMenuItemTakingItemToBeReturned() {
        View view = mock(View.class);
        Librarian librarian = mock(Librarian.class);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, searchResult);
        menuItemController.returnBook(librarian, "book", "b01-0001");

        verify(view).readInput();
    }

    @Test
    public void specToTestReturnOptionSearchesMatchingItemInCheckedOutList() {
        View view = mock(View.class);
        Librarian librarian = mock(Librarian.class);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, searchResult);
        menuItemController.returnBook(librarian, "book", "b01-0001");

        verify(librarian).searchCheckedOutList("java", searchResult);

    }

    @Test
    public void specToTestAfterGettingSearchResultCallReturnItemInLibrarian() {
        View view = mock(View.class);
        Librarian librarian = mock(Librarian.class);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, searchResult);
        menuItemController.returnBook(librarian, "book", "b01-0001");

        verify(librarian).returnItem(searchResult, "book","b01-0001");
    }

    @Test
    public void specToCheckListMoviesMenuItem() {
        View view = mock(View.class);
        Movies movies = mock(Movies.class);
        Librarian librarian = mock(Librarian.class);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        MenuItemController menuItemController = new MenuItemController(view, searchResult);

        menuItemController.listMovies(movies);

        verify(view).printToConsole(movies.toString());
    }
}
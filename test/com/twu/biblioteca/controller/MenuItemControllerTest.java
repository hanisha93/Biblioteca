package com.twu.biblioteca.controller;

import com.twu.biblioteca.Item;
import com.twu.biblioteca.User;
import com.twu.biblioteca.View;
import com.twu.biblioteca.models.LibrarianJob;
import com.twu.biblioteca.models.Books;
import com.twu.biblioteca.models.Movies;
import com.twu.biblioteca.models.UserProfile;
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
        LibrarianJob librarianJob = mock(LibrarianJob.class);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, searchResult);
        menuItemController.checkOut(librarianJob, "book", "b01-001");

        verify(view, times(2)).printToConsole(anyString());
    }

    @Test
    public void specToTestCheckOutItemTakingitemTitleToBeCheckedOut() {
        View view = mock(View.class);
        LibrarianJob librarianJob = mock(LibrarianJob.class);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, searchResult);
        menuItemController.checkOut(librarianJob, "movie", "b01-001");

        verify(view).readInput();

    }

    @Test
    public void specToTestCheckoutItemOptionSearchesMatchingItemInLibrary() {
        View view = mock(View.class);
        LibrarianJob librarianJob = mock(LibrarianJob.class);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, searchResult);
        menuItemController.checkOut(librarianJob, "book", "b01-0001");

        verify(librarianJob).searchItem("java", searchResult);

    }

    @Test
    public void specToTestAfterGettingSearchResultCallDoCheckoutInLibrarian() {
        View view = mock(View.class);
        LibrarianJob librarianJob = mock(LibrarianJob.class);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, searchResult);
        menuItemController.checkOut(librarianJob, "movie", "b01-0001");

        verify(librarianJob).doCheckout(searchResult, "movie", "b01-0001");
    }

    @Test
    public void specToTestReturnItemOptionDisplayingReturnMessages() {
        View view = mock(View.class);
        LibrarianJob librarianJob = mock(LibrarianJob.class);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, searchResult);
        menuItemController.returnBook(librarianJob, "book", "b01-001");

        verify(view, times(2)).printToConsole(anyString());
    }

    @Test
    public void specToTestReturnItemMenuItemTakingItemToBeReturned() {
        View view = mock(View.class);
        LibrarianJob librarianJob = mock(LibrarianJob.class);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, searchResult);
        menuItemController.returnBook(librarianJob, "book", "b01-0001");

        verify(view).readInput();
    }

    @Test
    public void specToTestReturnOptionSearchesMatchingItemInCheckedOutList() {
        View view = mock(View.class);
        LibrarianJob librarianJob = mock(LibrarianJob.class);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, searchResult);
        menuItemController.returnBook(librarianJob, "book", "b01-0001");

        verify(librarianJob).searchCheckedOutList("java", searchResult);

    }

    @Test
    public void specToTestAfterGettingSearchResultCallReturnItemInLibrarian() {
        View view = mock(View.class);
        LibrarianJob librarianJob = mock(LibrarianJob.class);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        when(view.readInput()).thenReturn("java");
        MenuItemController menuItemController = new MenuItemController(view, searchResult);
        menuItemController.returnBook(librarianJob, "book", "b01-0001");

        verify(librarianJob).acceptReturnItem(searchResult, "book", "b01-0001");
    }

    @Test
    public void specToCheckListMoviesMenuItem() {
        View view = mock(View.class);
        Movies movies = mock(Movies.class);
        LibrarianJob librarianJob = mock(LibrarianJob.class);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        MenuItemController menuItemController = new MenuItemController(view, searchResult);

        menuItemController.listMovies(movies);

        verify(view).printToConsole(movies.toString());
    }

    @Test
    public void specToTestCheckedOutDetailsGettingDetailFromLibrarainJob() {
        View view = mock(View.class);
        Movies movies = mock(Movies.class);
        LibrarianJob librarianJob = mock(LibrarianJob.class);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        MenuItemController menuItemController = new MenuItemController(view, searchResult);

        menuItemController.handleCheckoutDetails(librarianJob);

        verify(librarianJob).getCheckOutDetails();
    }

    @Test
    public void specToTestDisplayingUserInformation() {
        View view = mock(View.class);
        UserProfile userProfile = mock(UserProfile.class);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        ArrayList<UserProfile> userProfiles = new ArrayList<>();
        userProfiles.add(new UserProfile("b01-0002", "hansiha", "897757488", "hanisha@gmail.com"));
        MenuItemController menuItemController = new MenuItemController(view, searchResult);

        menuItemController.displayUserInformation(userProfiles, "b01-0002");

        verify(view).printToConsole("b01-0002  hansiha  897757488  hanisha@gmail.com");
    }

    /*@Test
    public void specToTestDisplayingUserInformationCalling() {
        View view = mock(View.class);
        UserProfile userProfile = mock(UserProfile.class);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        ArrayList<UserProfile> userProfiles = new ArrayList<>();
        userProfiles.add(new UserProfile("b01-0002", "hansiha", "897757488", "hanisha@gmail.com"));
        MenuItemController menuItemController = new MenuItemController(view, searchResult);

        menuItemController.displayUserInformation(userProfiles, "b01-0002");

        verify(userProfile, times(1)).matchLibraryId("b01-0002");
    }*/
}
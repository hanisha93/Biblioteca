package com.twu.biblioteca.models;

import com.twu.biblioteca.Item;
import com.twu.biblioteca.item.Book;
import com.twu.biblioteca.item.Movie;
import com.twu.biblioteca.models.LibrarianJob;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class LibrarianJobTest {

    @Test
    public void specForCheckingSearchBookItemWhenItemTitleMatches() {
        ArrayList<Item> list = new ArrayList<Item>();
        list.add(new Book("Java", "wilson", "1998"));
        list.add(new Book("c", "johnson", "2000"));
        ArrayList<Item> result = new ArrayList<Item>();
        HashMap<Item, String> users = new HashMap<>();
        LibrarianJob librarianJob = new LibrarianJob(list, list, users);

        ArrayList<Item> actualBooks = librarianJob.searchItem("Java", result);
        ArrayList<Item> expectedBooks = new ArrayList<Item>();
        expectedBooks.add(new Book("Java", "wilson", "1998"));

        assertEquals(actualBooks, expectedBooks);
    }

    @Test
    public void specForCheckingSearchBookItemWhenBookTitleDoesNotMatches() {
        ArrayList<Item> list = new ArrayList<Item>();
        list.add(new Book("Java", "wilson", "1998"));
        list.add(new Book("c", "johnson", "2000"));
        ArrayList<Item> result = new ArrayList<Item>();
        HashMap<Item, String> users = new HashMap<>();
        LibrarianJob listOfBooks = new LibrarianJob(list, list, users);

        ArrayList<Item> actualBooks = listOfBooks.searchItem("The lord of rings", result);
        ArrayList<Item> expectedBooks = new ArrayList<Item>();

        assertEquals(actualBooks, expectedBooks);
    }

    @Test
    public void specToTestSearchCheckedOutListWhenBookTitleMatches() {
        ArrayList<Item> list = new ArrayList<Item>();
        Book book = new Book("Java", "wilson", "1998");
        list.add(book);
        list.add(new Book("c", "johnson", "2000"));
        ArrayList<Item> result = new ArrayList<Item>();
        HashMap<Item, String> users = new HashMap<>();
        users.put(book, "b01-0001");
        LibrarianJob listOfBooks = new LibrarianJob(list, list, users);

        ArrayList<Item> actualBooks = listOfBooks.searchCheckedOutList("Java", result, "b01-0001");
        ArrayList<Item> expectedBooks = new ArrayList<Item>();
        expectedBooks.add(new Book("Java", "wilson", "1998"));

        assertEquals(actualBooks, expectedBooks);
    }

    @Test
    public void specToTestSearchCheckedOutListWhenBookItemTitleDoesNotMatches() {


        ArrayList<Item> list = new ArrayList<Item>();
        list.add(new Book("Java", "wilson", "1998"));
        list.add(new Book("c", "johnson", "2000"));
        ArrayList<Item> result = new ArrayList<Item>();
        HashMap<Item, String> users = new HashMap<>();
        LibrarianJob listOfBooks = new LibrarianJob(list, list, users);

        ArrayList<Item> actualBooks = listOfBooks.searchCheckedOutList("The lord of rings", result,"b01-0002");
        ArrayList<Item> expectedBooks = new ArrayList<Item>();

        assertEquals(actualBooks, expectedBooks);
    }

    @Test
    public void specToTestDoCheckoutAddingBookItemToCheckedOutListWhenSearchResultHasBook() {
        ArrayList<Item> listOfBooks = new ArrayList<Item>();
        listOfBooks.add(new Book("java", "john", "2000"));
        Book book = new Book("java", "john", "2000");
        ArrayList<Item> checkedOutList = new ArrayList<Item>();
        ArrayList<Item> searchResult = new ArrayList<Item>();
        HashMap<Item, String> users = new HashMap<>();
        searchResult.add(book);
        LibrarianJob librarianJob = new LibrarianJob(listOfBooks, checkedOutList, users);
        librarianJob.doCheckout(searchResult, "book", "b01-0001");

        ArrayList<Item> expectedList = new ArrayList<Item>();
        expectedList.add(new Book("java", "john", "2000"));

        assertThat(checkedOutList, is(expectedList));
    }

    @Test
    public void specToCheckDoCheckOutIsRemovingBookItemFromBooksListInLibraryWhenSearchResultHasBook() {
        ArrayList<Item> listOfBooks = new ArrayList<Item>();
        listOfBooks.add(new Book("java", "john", "2000"));
        Book book = new Book("java", "john", "2000");
        ArrayList<Item> checkedOutList = new ArrayList<Item>();
        ArrayList<Item> searchResult = new ArrayList<Item>();
        HashMap<Item, String> users = new HashMap<>();
        searchResult.add(book);
        LibrarianJob librarianJob = new LibrarianJob(listOfBooks, checkedOutList, users);
        librarianJob.doCheckout(searchResult, "book", "b01-0001");

        ArrayList<Item> expectedList = new ArrayList<Item>();

        assertThat(listOfBooks, is(expectedList));
    }

    @Test
    public void specToCheckReturnBookItemIsAddingItemToListOfItemsInLibraryWhenSearcHListIsNotEmpty() {
        ArrayList<Item> listOfBooks = new ArrayList<Item>();
        HashMap<Item, String> users = new HashMap<>();
        Book book = new Book("java", "john", "2000");
        ArrayList<Item> checkedOutList = new ArrayList<Item>();
        checkedOutList.add(book);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        searchResult.add(book);
        LibrarianJob librarianJob = new LibrarianJob(listOfBooks, checkedOutList, users);
        librarianJob.acceptReturnItem(searchResult, "book", "b01-0001");

        ArrayList<Item> expectedList = new ArrayList<Item>();
        expectedList.add(book);

        assertThat(listOfBooks, is(expectedList));
    }

    @Test
    public void specToTestReturnItemRemovesBookFromCheckedOutListWhenSearchResultHasBook() {
        ArrayList<Item> listOfBooks = new ArrayList<Item>();
        Book book = new Book("java", "john", "2000");
        ArrayList<Item> checkedOutList = new ArrayList<Item>();
        checkedOutList.add(book);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        searchResult.add(book);
        HashMap<Item, String> users = new HashMap<>();
        LibrarianJob librarianJob = new LibrarianJob(listOfBooks, checkedOutList, users);
        librarianJob.acceptReturnItem(searchResult, "book", "b01-0001");

        ArrayList<Item> expectedList = new ArrayList<Item>();

        assertThat(checkedOutList, is(expectedList));
    }

    @Test
    public void specForTestingSearchItemAddsMovieItemToSearchResultWhenMovieTitleMatches() {
        ArrayList<Item> list = new ArrayList<Item>();
        Movie movie = new Movie("Avatar", "2011", "cameroon", "7");
        list.add(movie);
        ArrayList<Item> result = new ArrayList<Item>();
        HashMap<Item, String> users = new HashMap<>();
        LibrarianJob librarianJob = new LibrarianJob(list, list, users);

        ArrayList<Item> actualMovies = librarianJob.searchItem("Avatar", result);
        ArrayList<Item> expectedMovies = new ArrayList<Item>();
        expectedMovies.add(movie);

        assertThat(actualMovies, is(expectedMovies));
    }

    @Test
    public void specForTestingSearchItemReturnsEmptySearchResultWhenMovieTitleOfItemDoesNotMatches() {
        ArrayList<Item> list = new ArrayList<Item>();
        Movie movie = new Movie("Avatar", "2011", "cameroon", "7");
        list.add(movie);
        ArrayList<Item> result = new ArrayList<Item>();
        HashMap<Item, String> users = new HashMap<>();
        LibrarianJob librarianJob = new LibrarianJob(list, list, users);

        ArrayList<Item> actualMovies = librarianJob.searchItem("Avata", result);
        ArrayList<Item> expectedMovies = new ArrayList<Item>();

        assertThat(actualMovies, is(expectedMovies));
    }

    @Test
    public void specToTestSearchCheckedOutListAddsMovieToSearchResultWhenMovieTitleMatches() {
        ArrayList<Item> list = new ArrayList<Item>();
        Movie movie = new Movie("Avatar", "2011", "cameroon", "7");
        list.add(movie);
        ArrayList<Item> result = new ArrayList<Item>();
        HashMap<Item, String> users = new HashMap<>();
        LibrarianJob librarianJob = new LibrarianJob(list, list, users);

        ArrayList<Item> actualMovies = librarianJob.searchItem("Avatar", result);
        ArrayList<Item> expectedMovies = new ArrayList<Item>();
        expectedMovies.add(movie);

        assertThat(actualMovies, is(expectedMovies));
    }

    @Test

    public void specToTestSearchCheckedOutListReturnsEmptySearchResultWhenMovieTitleNotMatches() {
        ArrayList<Item> list = new ArrayList<Item>();
        Movie movie = new Movie("Avatar", "2011", "cameroon", "7");
        list.add(movie);
        ArrayList<Item> result = new ArrayList<Item>();
        HashMap<Item, String> users = new HashMap<>();
        LibrarianJob librarianJob = new LibrarianJob(list, list, users);

        ArrayList<Item> actualMovies = librarianJob.searchItem("Avata", result);
        ArrayList<Item> expectedMovies = new ArrayList<Item>();

        assertThat(actualMovies, is(expectedMovies));
    }

    @Test
    public void specToTestDoCheckoutAddingMovieItemToCheckedOutListWhenSearchResultHasMovie() {
        ArrayList<Item> movieslist = new ArrayList<Item>();
        ArrayList<Item> checkedOutlist = new ArrayList<Item>();
        Movie movie = new Movie("Avatar", "2011", "cameroon", "7");
        movieslist.add(movie);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        searchResult.add(movie);
        HashMap<Item, String> users = new HashMap<>();
        LibrarianJob librarianJob = new LibrarianJob(movieslist, checkedOutlist, users);

        librarianJob.doCheckout(searchResult, "movie", "b01-0001");
        ArrayList<Item> expectedMovies = new ArrayList<Item>();
        expectedMovies.add(movie);

        assertThat(checkedOutlist, is(expectedMovies));
    }

    @Test
    public void specToTestDoCheckoutRemovingMovieItemFromItemsInLibraryWhenSearchResultHasMovie() {
        ArrayList<Item> movieslist = new ArrayList<Item>();
        ArrayList<Item> checkedOutlist = new ArrayList<Item>();
        Movie movie = new Movie("Avatar", "2011", "cameroon", "7");
        movieslist.add(movie);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        searchResult.add(movie);
        HashMap<Item, String> users = new HashMap<>();
        LibrarianJob librarianJob = new LibrarianJob(movieslist, checkedOutlist, users);

        librarianJob.doCheckout(searchResult, "movie", "b01-0001");
        ArrayList<Item> expectedList = new ArrayList<Item>();

        assertThat(movieslist, is(expectedList));
    }

    @Test
    public void specToTestReturnItemRemovingMovieItemFromCheckedOutListWhenSearchResultHasMovie() {
        ArrayList<Item> movieslist = new ArrayList<Item>();
        ArrayList<Item> checkedOutlist = new ArrayList<Item>();
        Movie movie = new Movie("Avatar", "2011", "cameroon", "7");
        checkedOutlist.add(movie);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        searchResult.add(movie);
        HashMap<Item, String> users = new HashMap<>();
        LibrarianJob librarianJob = new LibrarianJob(movieslist, checkedOutlist, users);

        librarianJob.acceptReturnItem(searchResult, "movie", "b01-0001");
        ArrayList<Item> expectedList = new ArrayList<Item>();

        assertThat(checkedOutlist, is(expectedList));
    }

    @Test
    public void specToTestReturnItemAddingMovieItemFromItemsInLibraryWhenSearchResultHasMovie() {
        ArrayList<Item> movieslist = new ArrayList<Item>();
        ArrayList<Item> checkedOutlist = new ArrayList<Item>();
        Movie movie = new Movie("Avatar", "2011", "cameroon", "7");
        checkedOutlist.add(movie);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        searchResult.add(movie);
        HashMap<Item, String> users = new HashMap<>();
        LibrarianJob librarianJob = new LibrarianJob(movieslist, checkedOutlist, users);

        librarianJob.acceptReturnItem(searchResult, "movie", "b01-0001");
        ArrayList<Item> expectedList = new ArrayList<Item>();
        expectedList.add(movie);

        assertThat(movieslist, is(expectedList));
    }

    @Test
    public void specToTestReturnItemReturnsSuccesfulMessageWhenSearchResultHasItem() {
        ArrayList<Item> movieslist = new ArrayList<Item>();
        ArrayList<Item> checkedOutlist = new ArrayList<Item>();
        Movie movie = new Movie("Avatar", "2011", "cameroon", "7");
        checkedOutlist.add(movie);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        searchResult.add(movie);
        HashMap<Item, String> users = new HashMap<>();
        LibrarianJob librarianJob = new LibrarianJob(movieslist, checkedOutlist, users);

        String message = librarianJob.acceptReturnItem(searchResult, "movie", "b01-0001");

        assertThat(message, is("     Thank you for returning the movie"));
    }

    @Test
    public void specToTestReturnItemReturnsFailureMessageWhenSearchResultIsEmpty() {
        ArrayList<Item> movieslist = new ArrayList<Item>();
        ArrayList<Item> checkedOutlist = new ArrayList<Item>();
        Movie movie = new Movie("Avatar", "2011", "cameroon", "7");
        checkedOutlist.add(movie);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        HashMap<Item, String> users = new HashMap<>();
        LibrarianJob librarianJob = new LibrarianJob(movieslist, checkedOutlist, users);

        String message = librarianJob.acceptReturnItem(searchResult, "movie", "b01-0001");

        assertThat(message, is("    That is not a valid movie"));
    }

    @Test
    public void specToTestDoCheckOutReturnsSuccesfulMessageWhenSearchResultHasItem() {
        ArrayList<Item> movieslist = new ArrayList<Item>();
        ArrayList<Item> checkedOutlist = new ArrayList<Item>();
        Movie movie = new Movie("Avatar", "2011", "cameroon", "7");
        checkedOutlist.add(movie);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        searchResult.add(movie);
        HashMap<Item, String> users = new HashMap<>();
        LibrarianJob librarianJob = new LibrarianJob(movieslist, checkedOutlist, users);

        String message = librarianJob.doCheckout(searchResult, "movie", "b01-0001");

        assertThat(message, is("     Thanq you! Enjoy the movie"));
    }

    @Test
    public void specToTestDoCheckOutReturnsFailureMessageWhenSearchResultHasNoItem() {
        ArrayList<Item> movieslist = new ArrayList<Item>();
        ArrayList<Item> checkedOutlist = new ArrayList<Item>();
        Movie movie = new Movie("Avatar", "2011", "cameroon", "7");
        checkedOutlist.add(movie);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        HashMap<Item, String> users = new HashMap<>();

        LibrarianJob librarianJob = new LibrarianJob(movieslist, checkedOutlist, users);

        String message = librarianJob.doCheckout(searchResult, "Movie", "b01-0001");

        assertThat(message, is("Movie is not available\n"));
    }

    @Test
    public void specToCheckGetCheckedOutItemsDetails() {
        ArrayList<Item> movieslist = new ArrayList<Item>();
        ArrayList<Item> checkedOutlist = new ArrayList<Item>();
        Movie movie = new Movie("Avatar", "2011", "cameroon", "7");
        checkedOutlist.add(movie);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        HashMap<Item, String> users = new HashMap<>();

        LibrarianJob librarianJob = new LibrarianJob(movieslist, checkedOutlist, users);
        HashMap<Item,String > ExpectedUsers = librarianJob.getCheckOutDetails();

        assertEquals(ExpectedUsers, users);
    }

}









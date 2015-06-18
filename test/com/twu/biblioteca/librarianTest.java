package com.twu.biblioteca;

import com.twu.biblioteca.item.Book;
import com.twu.biblioteca.item.Movie;
import com.twu.biblioteca.models.Librarian;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.mockito.cglib.core.CollectionUtils;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class LibrarianTest {

    @Test
    public void specForCheckingSearchBookItemWhenItemTitleMatches() {
        ArrayList<Item> list = new ArrayList<Item>();
        list.add(new Book("Java", "wilson", "1998"));
        list.add(new Book("c", "johnson", "2000"));
        ArrayList<Item> result = new ArrayList<Item>();
        Librarian librarian = new Librarian(list, list);

        ArrayList<Item> actualBooks = librarian.searchItem("Java", result);
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
        Librarian listOfBooks = new Librarian(list, list);

        ArrayList<Item> actualBooks = listOfBooks.searchItem("The lord of rings", result);
        ArrayList<Item> expectedBooks = new ArrayList<Item>();

        assertEquals(actualBooks, expectedBooks);
    }

    @Test
    public void specToTestSearchCheckedOutListWhenBookTitleMatches() {
        ArrayList<Item> list = new ArrayList<Item>();
        list.add(new Book("Java", "wilson", "1998"));
        list.add(new Book("c", "johnson", "2000"));
        ArrayList<Item> result = new ArrayList<Item>();
        Librarian listOfBooks = new Librarian(list, list);

        ArrayList<Item> actualBooks = listOfBooks.searchCheckedOutList("Java", result);
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
        Librarian listOfBooks = new Librarian(list, list);

        ArrayList<Item> actualBooks = listOfBooks.searchCheckedOutList("The lord of rings", result);
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
        searchResult.add(book);
        Librarian librarian = new Librarian(listOfBooks, checkedOutList);
        librarian.doCheckout(searchResult, "book");

        ArrayList<Item> expectedList = new ArrayList<Item>();
        expectedList.add(new Book("java", "john", "2000"));

        assertThat(checkedOutList, is(expectedList));
    }

    @Test
    public void specToCheckRemovingBookItemFromBooksListInLibrary() {
        ArrayList<Item> listOfBooks = new ArrayList<Item>();
        listOfBooks.add(new Book("java", "john", "2000"));
        Book book = new Book("java", "john", "2000");
        ArrayList<Item> checkedOutList = new ArrayList<Item>();
        ArrayList<Item> searchResult = new ArrayList<Item>();
        searchResult.add(book);
        Librarian librarian = new Librarian(listOfBooks, checkedOutList);
        librarian.doCheckout(searchResult, "book");

        ArrayList<Item> expectedList = new ArrayList<Item>();

        assertThat(listOfBooks, is(expectedList));
    }

    @Test
    public void specToCheckReturnBookItemIsAddingItemToListOfItemInLibrary() {
        ArrayList<Item> listOfBooks = new ArrayList<Item>();
        Book book = new Book("java", "john", "2000");
        ArrayList<Item> checkedOutList = new ArrayList<Item>();
        checkedOutList.add(book);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        searchResult.add(book);
        Librarian librarian = new Librarian(listOfBooks, checkedOutList);
        librarian.returnItem(searchResult, "book");

        ArrayList<Item> expectedList = new ArrayList<Item>();
        expectedList.add(book);

        assertThat(listOfBooks, is(expectedList));
    }

    @Test
    public void specToCheckReturnBookItemIsRemovedFromCheckedOutList() {
        ArrayList<Item> listOfBooks = new ArrayList<Item>();
        Book book = new Book("java", "john", "2000");
        ArrayList<Item> checkedOutList = new ArrayList<Item>();
        checkedOutList.add(book);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        searchResult.add(book);
        Librarian librarian = new Librarian(listOfBooks, checkedOutList);
        librarian.returnItem(searchResult, "book");

        ArrayList<Item> expectedList = new ArrayList<Item>();

        assertThat(checkedOutList, is(expectedList));
    }

    @Test
    public void specForTestingSearchItemAddsMovieItemToSearchResultWhenMovieTitleMatches() {
        ArrayList<Item> list = new ArrayList<Item>();
        Movie movie = new Movie("Avatar", "2011", "cameroon", "7");
        list.add(movie);
        ArrayList<Item> result = new ArrayList<Item>();
        Librarian librarian = new Librarian(list, list);

        ArrayList<Item> actualMovies = librarian.searchItem("Avatar", result);
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
        Librarian librarian = new Librarian(list, list);

        ArrayList<Item> actualMovies = librarian.searchItem("Avata", result);
        ArrayList<Item> expectedMovies = new ArrayList<Item>();

        assertThat(actualMovies, is(expectedMovies));
    }

    @Test
    public void specToTestSearchCheckedOutListAddsMovieToSearchResultWhenMovieTitleMatches() {
        ArrayList<Item> list = new ArrayList<Item>();
        Movie movie = new Movie("Avatar", "2011", "cameroon", "7");
        list.add(movie);
        ArrayList<Item> result = new ArrayList<Item>();
        Librarian librarian = new Librarian(list, list);

        ArrayList<Item> actualMovies = librarian.searchItem("Avatar", result);
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
        Librarian librarian = new Librarian(list, list);

        ArrayList<Item> actualMovies = librarian.searchItem("Avata", result);
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
        Librarian librarian = new Librarian(movieslist, checkedOutlist);

        librarian.doCheckout(searchResult, "movie");
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
        Librarian librarian = new Librarian(movieslist, checkedOutlist);

        librarian.doCheckout(searchResult, "movie");
        ArrayList<Item> expectedList = new ArrayList<Item>();

        assertThat(movieslist, is(expectedList));
    }

}









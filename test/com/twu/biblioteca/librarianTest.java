package com.twu.biblioteca;

import com.twu.biblioteca.item.Book;
import com.twu.biblioteca.models.Librarian;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class librarianTest {

    @Test
    public void specForCheckingSearchBookWhenBookTitleMatches() {
        ArrayList<Item> list = new ArrayList<Item>();
        list.add(new Book("Java", "wilson", "1998"));
        list.add(new Book("c", "johnson", "2000"));
        ArrayList<Item> result = new ArrayList<Item>();
        Librarian listOfBooks = new Librarian(list, list);

        ArrayList<Item> actualBooks = listOfBooks.searchBook("Java", result);
        ArrayList<Item> expectedBooks = new ArrayList<Item>();
        expectedBooks.add(new Book("Java", "wilson", "1998"));

        assertEquals(actualBooks, expectedBooks);
    }

    @Test
    public void specForCheckingSearchBookWhenBookTitleDoesNotMatches() {
        ArrayList<Item> list = new ArrayList<Item>();
        list.add(new Book("Java", "wilson", "1998"));
        list.add(new Book("c", "johnson", "2000"));
        ArrayList<Item> result = new ArrayList<Item>();
        Librarian listOfBooks = new Librarian(list,list);

        ArrayList<Item> actualBooks = listOfBooks.searchBook("The lord of rings", result);
        ArrayList<Item> expectedBooks = new ArrayList<Item>();

        assertEquals(actualBooks, expectedBooks);
    }

    @Test
    public void specForCheckingSearchCheckedOutListWhenBookTitleMatches() {
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
    public void specForCheckingSearchCheckedOutListWhenBookTitleDoesNotMatches() {


        ArrayList<Item> list = new ArrayList<Item>();
        list.add(new Book("Java", "wilson", "1998"));
        list.add(new Book("c", "johnson", "2000"));
        ArrayList<Item> result = new ArrayList<Item>();
        Librarian listOfBooks = new Librarian(list,list);

        ArrayList<Item> actualBooks = listOfBooks.searchCheckedOutList("The lord of rings", result);
        ArrayList<Item> expectedBooks = new ArrayList<Item>();

        assertEquals(actualBooks, expectedBooks);
    }

    @Test
    public void specToCheckAddingBookToCheckedOutList() {
        ArrayList<Item> listOfBooks = new ArrayList<Item>();
        listOfBooks.add(new Book("java", "john", "2000"));
        Book book = new Book("java", "john", "2000");
        ArrayList<Item> checkedOutList = new ArrayList<Item>();
        ArrayList<Item> searchResult = new ArrayList<Item>();
        searchResult.add(book);
        Librarian librarian = new Librarian(listOfBooks, checkedOutList);
        librarian.doCheckout(searchResult);

        ArrayList<Item> expectedList = new ArrayList<Item>();
        expectedList.add(new Book("java", "john", "2000"));

        assertThat(checkedOutList, is(expectedList));
    }

    @Test
    public void specToCheckRemovingBookFromBooksListInLibrary() {
        ArrayList<Item> listOfBooks = new ArrayList<Item>();
        listOfBooks.add(new Book("java", "john", "2000"));
        Book book = new Book("java", "john", "2000");
        ArrayList<Item> checkedOutList = new ArrayList<Item>();
        ArrayList<Item> searchResult = new ArrayList<Item>();
        searchResult.add(book);
        Librarian librarian = new Librarian(listOfBooks, checkedOutList);
        librarian.doCheckout(searchResult);

        ArrayList<Item> expectedList = new ArrayList<Item>();

        assertThat(listOfBooks, is(expectedList));
    }

    @Test
    public void specToCheckReturnBookIsAddingBookToListOfBooksInLibrary() {
        ArrayList<Item> listOfBooks = new ArrayList<Item>();
        Book book = new Book("java", "john", "2000");
        ArrayList<Item> checkedOutList = new ArrayList<Item>();
        checkedOutList.add(book);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        searchResult.add(book);
        Librarian librarian = new Librarian(listOfBooks, checkedOutList);
        librarian.returnBook(searchResult);

        ArrayList<Item> expectedList = new ArrayList<Item>();
        expectedList.add(book);

        assertThat(listOfBooks, is(expectedList));
    }

    @Test
    public void specToCheckReturnBookIsRemovedFromCheckedOutList() {
        ArrayList<Item> listOfBooks = new ArrayList<Item>();
        Book book = new Book("java", "john", "2000");
        ArrayList<Item> checkedOutList = new ArrayList<Item>();
        checkedOutList.add(book);
        ArrayList<Item> searchResult = new ArrayList<Item>();
        searchResult.add(book);
        Librarian librarian = new Librarian(listOfBooks, checkedOutList);
        librarian.returnBook(searchResult);

        ArrayList<Item> expectedList = new ArrayList<Item>();

        assertThat(checkedOutList, is(expectedList));
    }
}









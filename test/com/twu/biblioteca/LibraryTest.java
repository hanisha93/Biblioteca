package com.twu.biblioteca;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LibraryTest {

    @Test
    public void specForCheckingToString() {


        ArrayList<Book> list = new ArrayList<Book>();
        list.add(new Book("Java", "wilson", "1998"));
        list.add(new Book("c", "johnson", "2000"));

        Library listOfBooks = new Library(list, list);

        String actualBooks = listOfBooks.toString();
        String expectedBooks = "Java wilson  1998\nc johnson  2000\n";

        assertEquals(actualBooks, expectedBooks);
    }

    @Test
    public void specForCheckingCompareBookReturningBooksWhenBookTitleMatches() {


        ArrayList<Book> list = new ArrayList<Book>();
        list.add(new Book("Java", "wilson", "1998"));
        list.add(new Book("c", "johnson", "2000"));
        ArrayList<Book> result = new ArrayList<Book>();
        Library listOfBooks = new Library(list, list);

        ArrayList<Book> actualBooks = listOfBooks.compareBooks("Java", result);
        ArrayList<Book> expectedBooks = new ArrayList<Book>();
        expectedBooks.add(new Book("Java", "wilson", "1998"));

        assertEquals(actualBooks, expectedBooks);
    }

    @Test
    public void specForCheckingCompareBookReturningBooksWhenBookTitleDoesNotMatches() {


        ArrayList<Book> list = new ArrayList<Book>();
        list.add(new Book("Java", "wilson", "1998"));
        list.add(new Book("c", "johnson", "2000"));
        ArrayList<Book> result = new ArrayList<Book>();
        Library listOfBooks = new Library(list,list);

        ArrayList<Book> actualBooks = listOfBooks.compareBooks("The lord of rings", result);
        ArrayList<Book> expectedBooks = new ArrayList<Book>();

        assertEquals(actualBooks, expectedBooks);
    }

    @Test
    public void specToCheckAddingBookToCheckedOutList() {


        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        listOfBooks.add(new Book("java", "john", "2000"));
        Book book = new Book("java", "john", "2000");
        ArrayList<Book> checkedList = new ArrayList<Book>();
        Library library = new Library(listOfBooks, checkedList);
        library.doCheckout(book);

        ArrayList<Book> expectedList = new ArrayList<Book>();
        expectedList.add(new Book("java", "john", "2000"));

        assertThat(checkedList, is(expectedList));
    }
}









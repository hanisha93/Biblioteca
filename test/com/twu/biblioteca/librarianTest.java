package com.twu.biblioteca;

import com.twu.biblioteca.models.Book;
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
        ArrayList<Book> list = new ArrayList<Book>();
        list.add(new Book("Java", "wilson", "1998"));
        list.add(new Book("c", "johnson", "2000"));
        ArrayList<Book> result = new ArrayList<Book>();
        Librarian listOfBooks = new Librarian(list, list);

        ArrayList<Book> actualBooks = listOfBooks.searchBook("Java", result);
        ArrayList<Book> expectedBooks = new ArrayList<Book>();
        expectedBooks.add(new Book("Java", "wilson", "1998"));

        assertEquals(actualBooks, expectedBooks);
    }

    @Test
    public void specForCheckingSearchBookWhenBookTitleDoesNotMatches() {


        ArrayList<Book> list = new ArrayList<Book>();
        list.add(new Book("Java", "wilson", "1998"));
        list.add(new Book("c", "johnson", "2000"));
        ArrayList<Book> result = new ArrayList<Book>();
        Librarian listOfBooks = new Librarian(list,list);

        ArrayList<Book> actualBooks = listOfBooks.searchBook("The lord of rings", result);
        ArrayList<Book> expectedBooks = new ArrayList<Book>();

        assertEquals(actualBooks, expectedBooks);
    }

    @Test
    public void specForCheckingSearchCheckedOutListWhenBookTitleMatches() {
        ArrayList<Book> list = new ArrayList<Book>();
        list.add(new Book("Java", "wilson", "1998"));
        list.add(new Book("c", "johnson", "2000"));
        ArrayList<Book> result = new ArrayList<Book>();
        Librarian listOfBooks = new Librarian(list, list);

        ArrayList<Book> actualBooks = listOfBooks.searchCheckedOutList("Java", result);
        ArrayList<Book> expectedBooks = new ArrayList<Book>();
        expectedBooks.add(new Book("Java", "wilson", "1998"));

        assertEquals(actualBooks, expectedBooks);
    }

    @Test
    public void specForCheckingSearchCheckedOutListWhenBookTitleDoesNotMatches() {


        ArrayList<Book> list = new ArrayList<Book>();
        list.add(new Book("Java", "wilson", "1998"));
        list.add(new Book("c", "johnson", "2000"));
        ArrayList<Book> result = new ArrayList<Book>();
        Librarian listOfBooks = new Librarian(list,list);

        ArrayList<Book> actualBooks = listOfBooks.searchCheckedOutList("The lord of rings", result);
        ArrayList<Book> expectedBooks = new ArrayList<Book>();

        assertEquals(actualBooks, expectedBooks);
    }

    @Test
    public void specToCheckAddingBookToCheckedOutList() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        listOfBooks.add(new Book("java", "john", "2000"));
        Book book = new Book("java", "john", "2000");
        ArrayList<Book> checkedOutList = new ArrayList<Book>();
        ArrayList<Book> searchResult = new ArrayList<Book>();
        searchResult.add(book);
        Librarian librarian = new Librarian(listOfBooks, checkedOutList);
        librarian.doCheckout(searchResult);

        ArrayList<Book> expectedList = new ArrayList<Book>();
        expectedList.add(new Book("java", "john", "2000"));

        assertThat(checkedOutList, is(expectedList));
    }

    @Test
    public void specToCheckRemovingBookFromBooksListInLibrary() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        listOfBooks.add(new Book("java", "john", "2000"));
        Book book = new Book("java", "john", "2000");
        ArrayList<Book> checkedOutList = new ArrayList<Book>();
        ArrayList<Book> searchResult = new ArrayList<Book>();
        searchResult.add(book);
        Librarian librarian = new Librarian(listOfBooks, checkedOutList);
        librarian.doCheckout(searchResult);

        ArrayList<Book> expectedList = new ArrayList<Book>();

        assertThat(listOfBooks, is(expectedList));
    }

    @Test
    public void specToCheckReturnBookIsAddingBookToListOfBooksInLibrary() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book book = new Book("java", "john", "2000");
        ArrayList<Book> checkedOutList = new ArrayList<Book>();
        checkedOutList.add(book);
        ArrayList<Book> searchResult = new ArrayList<Book>();
        searchResult.add(book);
        Librarian librarian = new Librarian(listOfBooks, checkedOutList);
        librarian.returnBook(searchResult);

        ArrayList<Book> expectedList = new ArrayList<Book>();
        expectedList.add(book);

        assertThat(listOfBooks, is(expectedList));
    }

    @Test
    public void specToCheckReturnBookIsRemovedFromCheckedOutList() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book book = new Book("java", "john", "2000");
        ArrayList<Book> checkedOutList = new ArrayList<Book>();
        checkedOutList.add(book);
        ArrayList<Book> searchResult = new ArrayList<Book>();
        searchResult.add(book);
        Librarian librarian = new Librarian(listOfBooks, checkedOutList);
        librarian.returnBook(searchResult);

        ArrayList<Book> expectedList = new ArrayList<Book>();

        assertThat(checkedOutList, is(expectedList));
    }
}









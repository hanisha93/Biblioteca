package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BookTest {

    @Test
    public void specForCheckingConcatenatingBookAttributes() {
        Book book = new Book("oopconcepts", "wilson", "1998");

        String actualBook = book.toString();
        String expectedBook = "oopconcepts wilson  1998";

        assertThat(actualBook, is(expectedBook));
    }

    @Test
    public void specForCheckingEqualityOfBook() {

        Book actualBook = new Book("oopconcepts", "wilson", "1998");
        Book expectedBook = new Book("oopconcepts", "john", "1998");

        assertThat(actualBook, is(expectedBook));
    }
}

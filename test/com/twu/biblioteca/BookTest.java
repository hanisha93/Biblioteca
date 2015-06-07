package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BookTest {

    @Test
    public void specForCheckingConcatenatingBookAttributes() {
        Book book = new Book("oopconcepts", "wilson", "1998");

        String actualBook = book.toString();
        String expectedBook = "oopconcepts wilson  1998";

        assertThat(actualBook, is(expectedBook));
    }
}

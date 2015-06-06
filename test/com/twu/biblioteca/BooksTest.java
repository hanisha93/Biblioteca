package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

public class BooksTest {

    @Test
    public void specForCheckingListOfBooks() {
        Books books = new Books();

        ArrayList<String> actualListOfbooks = books.listBooks();
        ArrayList<String> expectedListOfbooks = new ArrayList(Arrays.asList("oopconcepts", "javaProgramming"));

        assertThat(actualListOfbooks, is(expectedListOfbooks));
    }

    @Test
    public void specForCheckingToStringConcatenatesBooks() {
        Books listOfBooks = new Books();

        String actualBooks = listOfBooks.toString();
        String expectedBooks = "Books{listOfBooks=[oopconcepts, javaProgramming]}";

        assertThat(actualBooks, is(expectedBooks));
    }
}

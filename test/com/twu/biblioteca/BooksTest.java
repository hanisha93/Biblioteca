package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BooksTest {

    @Test
    public void specForCheckingToString() {
        Books listOfBooks = new Books();

        String actualBooks = listOfBooks.toString();
        String expectedBooks = "\\noopconcepts wilson  2000\\njavaProgramming johnson  1998";

        assertEquals(actualBooks, expectedBooks);
    }
}


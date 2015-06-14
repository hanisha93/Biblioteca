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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BooksTest {

    @Test
    public void specForCheckingToString() {


        ArrayList<Book> list=new ArrayList<Book>();
        list.add(new Book("Java", "wilson", "1998"));
        list.add(new Book("c", "johnson","2000"));

        Books listOfBooks = new Books(list);

        String actualBooks = listOfBooks.toString();
        String expectedBooks = "Java wilson  1998\nc johnson  2000\n";

        assertEquals(actualBooks, expectedBooks);
    }
}


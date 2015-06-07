package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class OutputMessagesTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void specForCheckingWelcomeMessageOnConsole() {
        OutputMessages msg = new OutputMessages();
        msg.displayWelcomeMessage();

        assertEquals("Welcome to Biblioteca App", outContent.toString());
    }

    @Test
    public void specForCheckingListOfBooksOnConsole() {
        OutputMessages msg = new OutputMessages();
        Books books = new Books();
        msg.displayListOfBooks(books);

        assertEquals("\\noopconcepts wilson  2000\\njavaProgramming johnson  1998", outContent.toString());
    }

    @Test
    public void specForCheckingDisplayingMenu() {
        OutputMessages msg = new OutputMessages();
        msg.displayMenu();

        assertEquals("Select option:\\n 1.ListBooks", outContent.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);

    }
}

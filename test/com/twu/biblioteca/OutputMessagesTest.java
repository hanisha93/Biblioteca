package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


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
        Books booksStubOne= mock(Books.class);
        when(booksStubOne.toString()).thenReturn("\\noopconcepts wilson  2000\\njavaProgramming johnson  1998");
        OutputMessages msg = new OutputMessages();
        msg.displayListOfBooks(booksStubOne);

        assertEquals("\\noopconcepts wilson  2000\\njavaProgramming johnson  1998", outContent.toString());
    }

    @Test
    public void specForCheckingDisplayingMenu() {
        OutputMessages msg = new OutputMessages();
        msg.displayMenu();

        assertEquals("Select option:\\n 1.ListBooks\\n 0.Quit", outContent.toString());
    }

    @Test
    public void specForCheckingDisplayingInvalidOption() {
        OutputMessages msg = new OutputMessages();
        msg.displayInvalidOption();

        assertEquals("Invalid option!! Select valid option", outContent.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
}

package com.twu.biblioteca;

import com.twu.biblioteca.models.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static java.lang.System.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class ViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        setOut(new PrintStream(outContent));
    }

    @Test
    public void specForCheckingPrintingMessageOnConsole() {
        View view = new View(new Scanner(System.in));
        view.printToConsole("Welcome");

        assertEquals("Welcome\n", outContent.toString());
    }

    @Test
    public void specForCheckingReadingInputFromConsole() {

        ByteArrayInputStream inContent = new ByteArrayInputStream("2".getBytes());
        System.setIn(inContent);
        View view = new View(new Scanner(System.in));
        String booksList = view.readInput();

        assertThat(booksList, is(equalTo("2")));
    }

    @Test
    public void specForCheckingReturnBookIsReturningCorrectBookObject() {

        ByteArrayInputStream inContent = new ByteArrayInputStream("Java core".getBytes());
        System.setIn(inContent);
        Book book = mock(Book.class);
        View view = new View(new Scanner(System.in));
        Book expectedBook = new Book("Java core", "", "");
        book = view.readBook();

        assertEquals(book, expectedBook);
    }

    @After
    public void cleanUpStreams() {
        setOut(null);
        System.setIn(System.in);
    }
}
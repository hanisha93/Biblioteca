package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static java.lang.System.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class BibliotecaViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        setOut(new PrintStream(outContent));
    }

    @Test
    public void specForCheckingPrintingMessageOnConsole() {
        BibliotecaView view = new BibliotecaView(new Scanner(System.in));
        view.printToConsole("Welcome");

        assertEquals("Welcome\n", outContent.toString());
    }

    @Test
    public void specForCheckingReadingInputFromConsole() {

        ByteArrayInputStream inContent = new ByteArrayInputStream("2 ".getBytes());
        System.setIn(inContent);
        BibliotecaView view = new BibliotecaView(new Scanner(System.in));
        int booksList = view.readInput();

        assertThat(booksList, is(equalTo(2)));
    }

    @After
    public void cleanUpStreams() {
        setOut(null);
        System.setIn(System.in);
    }
}
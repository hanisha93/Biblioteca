package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class BibliotecaViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Rule
    public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void specForCheckingPrintingMessageOnConsole() {
        BibliotecaView view = new BibliotecaView();
        view.printToConsole("Welcome");

        assertEquals("Welcome\n", outContent.toString());
    }

    @Test
    public void specForCheckingReadingInputFromConsole() {
        systemInMock.provideText("booksList");
        BibliotecaView view = new BibliotecaView();

        assertEquals("booksList", view.readInput());
    }


    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
}
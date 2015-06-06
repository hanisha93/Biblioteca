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

    @After
    public void cleanUpStreams() {
        System.setOut(null);

    }
}

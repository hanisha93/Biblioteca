
package com.twu.biblioteca;

import com.twu.biblioteca.Books;
import com.twu.biblioteca.OutputMessages;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class MenuHandlerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void specForCheckingOptionOfListBooks() {
        MenuHandler menu=new MenuHandler();
        menu.selectMenu(1);

        assertEquals("Select option:\\n 1.ListBooks\\noopconcepts wilson  2000\\njavaProgramming johnson  1998", outContent.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
}

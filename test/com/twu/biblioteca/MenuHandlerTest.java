package com.twu.biblioteca;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class MenuHandlerTest {

    @Test
    public void specForCheckingMenu() {
        Books booksStub = mock(Book.class);
        MenuHandler menu = new MenuHandler(1);

        assertEquals(1,1);

    }

    private Books mock(Class<Book> bookClass) {
        return null;
    }
}

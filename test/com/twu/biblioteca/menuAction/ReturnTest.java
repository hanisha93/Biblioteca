package com.twu.biblioteca.menuAction;

import com.twu.biblioteca.Item;
import com.twu.biblioteca.controller.MenuItemController;
import com.twu.biblioteca.models.Librarian;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ReturnTest {

    @Test
    public void specToCheckHandleOptionInReturn() {
        ArrayList<Item> searchResult = new ArrayList<Item>();
        Librarian librarian = mock(Librarian.class);
        MenuItemController menuItemController = mock(MenuItemController.class);
        Return returnBook = new Return(menuItemController, librarian, "book");
        returnBook.performAction("b01-0001");

        verify(menuItemController).returnBook(librarian, "book", "b01-0001");
    }
}
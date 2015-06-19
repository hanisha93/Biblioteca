package com.twu.biblioteca.menuAction;

import com.twu.biblioteca.Item;
import com.twu.biblioteca.controller.MenuItemController;
import com.twu.biblioteca.models.LibrarianJob;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ReturnTest {

    @Test
    public void specToCheckHandleOptionInReturn() {
        ArrayList<Item> searchResult = new ArrayList<Item>();
        LibrarianJob librarianJob = mock(LibrarianJob.class);
        MenuItemController menuItemController = mock(MenuItemController.class);
        Return returnBook = new Return(menuItemController, librarianJob, "book");
        returnBook.performAction("b01-0001");

        verify(menuItemController).returnBook(librarianJob, "book", "b01-0001");
    }
}
package com.twu.biblioteca.menuAction;

import com.twu.biblioteca.Item;
import com.twu.biblioteca.controller.MenuItemController;
import com.twu.biblioteca.models.LibrarianJob;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CheckOutTest {

    @Test
    public void specToCheckHandleOptionInCheckOut() {
        ArrayList<Item> searchResult = new ArrayList<Item>();
        LibrarianJob librarianJob = mock(LibrarianJob.class);
        MenuItemController menuItemController = mock(MenuItemController.class);
        CheckOut checkOut = new CheckOut(menuItemController, librarianJob, "book");
        checkOut.performAction("b01-0001");

        verify(menuItemController, Mockito.times(1)).checkOut(librarianJob, "book" ,"b01-0001");
    }
}
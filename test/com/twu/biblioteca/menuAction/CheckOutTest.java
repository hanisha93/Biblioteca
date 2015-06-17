package com.twu.biblioteca.menuAction;

import com.twu.biblioteca.Item;
import com.twu.biblioteca.controller.MenuItemController;
import com.twu.biblioteca.models.Librarian;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CheckOutTest {

    @Test
    public void specToCheckHandleOptionInCheckOut() {
        ArrayList<Item> searchResult = new ArrayList<Item>();
        Librarian librarian = mock(Librarian.class);
        MenuItemController menuItemController = mock(MenuItemController.class);
        CheckOut checkOut = new CheckOut(menuItemController, librarian);
        checkOut.performAction();

        verify(menuItemController, Mockito.times(1)).checkOut(librarian);
    }
}
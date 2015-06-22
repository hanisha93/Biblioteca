package com.twu.biblioteca.menuAction;

import com.twu.biblioteca.controller.MenuItemController;
import com.twu.biblioteca.models.LibrarianJob;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CheckedOutItemDetailsOptionTest {

    @Test
    public void specToCheckUsersWhoChckedBooksOptionCallingMenuController() {
        LibrarianJob librarianJob = mock(LibrarianJob.class);
        MenuItemController menuItemController = mock(MenuItemController.class);
        CheckedOutItemDetailsOption checkedOutItemDetailsOption = new CheckedOutItemDetailsOption(menuItemController, librarianJob);
        checkedOutItemDetailsOption.performAction("001-0001");
        verify(menuItemController).handleCheckoutDetails(librarianJob);
    }
}
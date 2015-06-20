package com.twu.biblioteca.menuAction;

import com.twu.biblioteca.controller.MenuItemController;
import com.twu.biblioteca.menuAction.CheckedOutItemDetails;
import com.twu.biblioteca.models.LibrarianJob;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CheckedOutItemDetailsTest {

    @Test
    public void specToCheckUsersWhoChckedBooksOptionCallingMenuController() {
        LibrarianJob librarianJob = mock(LibrarianJob.class);
        MenuItemController menuItemController = mock(MenuItemController.class);
        CheckedOutItemDetails checkedOutItemDetails = new CheckedOutItemDetails(menuItemController, librarianJob);
        checkedOutItemDetails.performAction("001-0001");
        verify(menuItemController).handleCheckoutDetails(librarianJob);
    }
}
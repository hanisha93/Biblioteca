package com.twu.biblioteca.menuAction;

import com.twu.biblioteca.controller.MenuItemController;
import com.twu.biblioteca.models.UserProfile;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ViewProfileOptionTest {

    @Test
    public void testPerformAction() {
        MenuItemController menuItemController = mock(MenuItemController.class);
        ArrayList<UserProfile> userProfiles = new ArrayList<>();
        ViewProfileOption viewProfileOption = new ViewProfileOption(menuItemController, userProfiles);
        viewProfileOption.performAction("b01-0001");

        verify(menuItemController).displayUserInformation(userProfiles, "b01-0001");
    }
}
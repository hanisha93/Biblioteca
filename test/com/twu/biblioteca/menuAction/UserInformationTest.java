package com.twu.biblioteca.menuAction;

import com.twu.biblioteca.controller.MenuItemController;
import com.twu.biblioteca.models.UserProfile;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class UserInformationTest {

    @Test
    public void testPerformAction() {
        MenuItemController menuItemController = mock(MenuItemController.class);
        ArrayList<UserProfile> userProfiles = new ArrayList<>();
        UserInformation userInformation = new UserInformation(menuItemController, userProfiles);
        userInformation.performAction("b01-0001");

        verify(menuItemController).displayUserInformation(userProfiles, "b01-0001");
    }
}
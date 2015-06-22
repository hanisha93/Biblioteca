package com.twu.biblioteca.menuAction;

import com.twu.biblioteca.controller.MenuItemController;
import com.twu.biblioteca.models.LibrarianJob;
import com.twu.biblioteca.models.UserProfile;

import java.util.ArrayList;

public class ViewProfileOption implements MenuAction {
    private MenuItemController menuItemController;
    private ArrayList<UserProfile> userProfiles;

    public ViewProfileOption(MenuItemController menuItemController, ArrayList<UserProfile> userProfiles) {
        this.menuItemController = menuItemController;
        this.userProfiles = userProfiles;
    }

    @Override
    public void performAction(String libraryNo) {
        menuItemController.displayUserInformation(userProfiles, libraryNo);
    }
}

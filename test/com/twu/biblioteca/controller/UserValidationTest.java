package com.twu.biblioteca.controller;

import com.twu.biblioteca.models.LibraryUser;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserValidationTest {

    @Test
    public void specToValidateUserReturnsRoleOfUserWhenUserIsValid() {
        LibraryUser libraryUser = new LibraryUser("b01-0001", "hanisha", "member");
        ArrayList<LibraryUser> libraryUsers = new ArrayList<LibraryUser>();
        libraryUsers.add(libraryUser);
        UserValidation userValidation = new UserValidation(libraryUsers);

        String role = userValidation.validateUser("b01-0001", "hanisha");

        assertEquals("member", role);
    }

    @Test
    public void specToValidateUserReturnsNullWhenUserIsInValid() {

        LibraryUser libraryUser = new LibraryUser("b01-0001", "hanisha", "librarian");
        LibraryUser libraryUserTwo = new LibraryUser("b01-0002", "priya", "member");
        ArrayList<LibraryUser> libraryUsers = new ArrayList<LibraryUser>();
        libraryUsers.add(libraryUser);
        libraryUsers.add(libraryUserTwo);
        UserValidation userValidation = new UserValidation(libraryUsers);

        String role = userValidation.validateUser("b01-000", "hanisha");

        assertEquals(role, null);
    }
}
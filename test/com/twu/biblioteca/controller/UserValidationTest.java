package com.twu.biblioteca.controller;

import com.twu.biblioteca.models.LibraryUser;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserValidationTest {

    @Test
    public void specToValidateUserReturnsTrueWhenUserIsValid() {
        LibraryUser libraryUser = new LibraryUser("b01-0001", "hanisha", "admin");
        ArrayList<LibraryUser> libraryUsers = new ArrayList<LibraryUser>();
        libraryUsers.add(libraryUser);
        UserValidation userValidation = new UserValidation(libraryUsers);

        //assertTrue(userValidation.validateUser("b01-0001", "hanisha"));
    }

    @Test
    public void specToValidateUserReturnsFalseWhenUserIsInValid() {

        LibraryUser libraryUser = new LibraryUser("b01-0001", "hanisha", "admin");
        LibraryUser libraryUserTwo = new LibraryUser("b01-0002", "priya", "admin");
        ArrayList<LibraryUser> libraryUsers = new ArrayList<LibraryUser>();
        libraryUsers.add(libraryUser);
        libraryUsers.add(libraryUserTwo);
        UserValidation userValidation = new UserValidation(libraryUsers);

       //assertFalse(userValidation.validateUser("b01-001", "hani"));
    }
}
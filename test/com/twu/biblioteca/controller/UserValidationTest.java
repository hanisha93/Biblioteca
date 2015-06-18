package com.twu.biblioteca.controller;

import com.twu.biblioteca.Messages;
import com.twu.biblioteca.View;
import com.twu.biblioteca.item.Movie;
import com.twu.biblioteca.models.LibraryUser;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static com.twu.biblioteca.Messages.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserValidationTest {

    @Test
    public void specToValidateUserReturnsTrueWhenUserIsValid() {
        LibraryUser libraryUser = new LibraryUser("b01-0001", "hanisha");
        ArrayList<LibraryUser> libraryUsers = new ArrayList<LibraryUser>();
        libraryUsers.add(libraryUser);
        UserValidation userValidation = new UserValidation(libraryUsers);

        assertTrue(userValidation.validateUser("b01-0001", "hanisha"));
    }

    @Test
    public void specToValidateUserReturnsFalseWhenUserIsInValid() {

        LibraryUser libraryUser = new LibraryUser("b01-0001", "hanisha");
        LibraryUser libraryUserTwo = new LibraryUser("b01-0002", "priya");
        ArrayList<LibraryUser> libraryUsers = new ArrayList<LibraryUser>();
        libraryUsers.add(libraryUser);
        libraryUsers.add(libraryUserTwo);
        UserValidation userValidation = new UserValidation(libraryUsers);

        assertFalse(userValidation.validateUser("b01-001", "hani"));
    }
}
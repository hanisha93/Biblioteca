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
        View view = mock(View.class);
        when(view.readInput()).thenReturn("Bhanisha1", "hanisha");
        LibraryUser libraryUser = new LibraryUser("Bhanisha1", "hanisha");
        ArrayList<LibraryUser> libraryUsers = new ArrayList<LibraryUser>();
        libraryUsers.add(libraryUser);
        UserValidation userValidation = new UserValidation(view, libraryUsers, libraryUser);

        assertTrue(userValidation.validateUser());
    }

    @Test
    public void specToValidateUserReturnsFalseWhenUserIsInValid() {
        View view = mock(View.class);
        when(view.readInput()).thenReturn("Bhanisha1", "hanisha");
        LibraryUser libraryUser = new LibraryUser("Bhanish", "hanisha");
        LibraryUser libraryUserTwo = new LibraryUser("Bpriya2", "priya");
        ArrayList<LibraryUser> libraryUsers = new ArrayList<LibraryUser>();
        libraryUsers.add(libraryUser);
        libraryUsers.add(libraryUserTwo);
        UserValidation userValidation = new UserValidation(view, libraryUsers, libraryUser);

        assertFalse(userValidation.validateUser());
    }

    @Test
    public void specToValidateUserDisplaysMessagesToGuideUserToGiveInput() {
        View view = mock(View.class);
        when(view.readInput()).thenReturn("Bhanisha1", "hanisha");
        LibraryUser libraryUser = new LibraryUser("Bhanish", "hanisha");
        LibraryUser libraryUserTwo = new LibraryUser("Bpriya2", "priya");
        ArrayList<LibraryUser> libraryUsers = new ArrayList<LibraryUser>();
        libraryUsers.add(libraryUser);
        libraryUsers.add(libraryUserTwo);
        UserValidation userValidation = new UserValidation(view, libraryUsers, libraryUser);
        userValidation.validateUser();

        verify(view,times(2)).printToConsole(anyString());
    }
}
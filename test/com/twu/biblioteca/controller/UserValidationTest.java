package com.twu.biblioteca.controller;

import com.twu.biblioteca.View;
import com.twu.biblioteca.models.LibraryUser;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
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
    
}
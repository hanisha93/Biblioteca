package com.twu.biblioteca.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryUserTest {

    @Test
    public void specToCheckEqualityOfLibraryUsers() {
        LibraryUser libraryUserOne = new LibraryUser("b01-0001", "hanisha", "admin");
        LibraryUser libraryUserTwo = new LibraryUser("b01-0001", "hanisha", "admin");

        assertTrue(libraryUserOne.equals(libraryUserTwo));
    }

    @Test
    public void specToCheckMatchUserReturnsTrueWhenIdAndPasswordMatchesTheOther() {
        LibraryUser libraryUser = new LibraryUser("b01-0001", "hanisha", "admin");

        assertTrue(libraryUser.matchUser("b01-0001", "hanisha"));
    }

    @Test
    public void specToCheckMatchUserReturnFalseWhenIdAndPasswordDoesNotMatches() {
        LibraryUser libraryUser = new LibraryUser("b02-0001", "hanisha", "admin");

        assertFalse(libraryUser.matchUser("b01-0002", "hanisha"));
    }

}
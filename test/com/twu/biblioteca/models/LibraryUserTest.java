package com.twu.biblioteca.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryUserTest {

    @Test
    public void specToCheckEqualityOfLibraryUsers() {
        LibraryUser libraryUserOne = new LibraryUser("Bhanisha1", "hanisha");
        LibraryUser libraryUserTwo = new LibraryUser("Bhanisha1", "hanisha");

        assertTrue(libraryUserOne.equals(libraryUserTwo));
    }

    @Test
    public void specToCheckMatchUserReturnsTrueWhenIdAndPasswordMatchesTheOther() {
        LibraryUser libraryUser = new LibraryUser("Bhanisha1", "hanisha");

        assertTrue(libraryUser.matchUser("Bhanisha1", "hanisha"));
    }

    @Test
    public void specToCheckMatchUserReturnFalseWhenIdAndPasswordDoesNotMatches() {
        LibraryUser libraryUser = new LibraryUser("Bhanisha1", "hanisha");

        assertFalse(libraryUser.matchUser("Bhanisha", "hanisha"));
    }
}
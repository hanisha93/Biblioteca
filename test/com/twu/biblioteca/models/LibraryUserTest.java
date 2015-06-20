package com.twu.biblioteca.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryUserTest {

    @Test
    public void specToCheckEqualityOfLibraryUsers() {
        LibraryUser libraryUserOne = new LibraryUser("b01-0001", "hanisha", "librarian");
        LibraryUser libraryUserTwo = new LibraryUser("b01-0001", "hanisha", "member");

        assertTrue(libraryUserOne.equals(libraryUserTwo));
    }

    @Test
    public void specToCheckMatchUserReturnsTrueWhenIdAndPasswordMatchesTheOther() {
        LibraryUser libraryUser = new LibraryUser("b01-0001", "hanisha", "librarian");

        assertTrue(libraryUser.matchUser("b01-0001", "hanisha"));
    }

    @Test
    public void specToCheckMatchUserReturnFalseWhenIdAndPasswordDoesNotMatches() {
        LibraryUser libraryUser = new LibraryUser("b02-0001", "hanisha", "member");

        assertFalse(libraryUser.matchUser("b01-0002", "hanisha"));
    }

    @Test
    public void testGetRole() {
        LibraryUser libraryUser = new LibraryUser("b02-0001", "hanisha", "librarian");

        String role = libraryUser.getRole();

        assertEquals(role, "librarian");
    }

}
package com.twu.biblioteca.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryUsersTest {

    @Test
    public void specToCheckEqualityOfLibraryUsers() {
        LibraryUsers libraryUsersOne = new LibraryUsers("Bhanisha1", "hanisha");
        LibraryUsers libraryUsersTwo = new LibraryUsers("Bhanisha1", "hanisha");

        assertTrue(libraryUsersOne.equals(libraryUsersTwo));
     }

}
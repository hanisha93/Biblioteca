package com.twu.biblioteca.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserProfileTest {

    @Test
    public void testToString() {
        UserProfile userProfile = new UserProfile("b01-0002", "hanisha", "8945738749", "has@gmail.com");
        String userInformation = userProfile.toString();

        assertEquals(userInformation, "b01-0002  hanisha  8945738749  has@gmail.com");
    }

    @Test
    public void testMatchLibraryIdReturnsTrueWhenMatches() {
        UserProfile userProfile = new UserProfile("b01-0002", "hanisha", "8945738749", "has@gmail.com");

        assertTrue(userProfile.matchLibraryId("b01-0002"));
    }

    @Test
    public void testMatchLibraryIdReturnsFalseWhenNotMatches() {
        UserProfile userProfile = new UserProfile("b01-0002", "hanisha", "8945738749", "has@gmail.com");

        assertFalse(userProfile.matchLibraryId("b01-0004"));
    }
}
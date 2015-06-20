package com.twu.biblioteca.models;

public class UserProfile {
    private String libraryId;
    private String name;
    private String phNo;
    private String emailId;

    public UserProfile(String libraryId, String name, String phNo, String emailId) {
        this.libraryId = libraryId;
        this.name = name;
        this.phNo = phNo;
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return libraryId + "  " + name + "  " + phNo + "  " + emailId;
    }

    public boolean matchLibraryId(String librarianId) {
        return this.libraryId.equals(librarianId);
    }
}

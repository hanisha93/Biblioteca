package com.twu.biblioteca.models;

public class LibraryUser {
    private String libraryId;
    private String password;
    private String role;

    public LibraryUser(String libraryId, String password, String role) {
        this.libraryId = libraryId;
        this.password = password;
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LibraryUser that = (LibraryUser) o;

        return libraryId.equals(that.libraryId) && password.equals(that.password);

    }

    public boolean matchUser(String libraryId, String password) {
        if((this.libraryId.equals(libraryId)) && (this.password.equals(password)))
                return true;
        return false;
    }

    public String getRole() {
        return this.role;
    }
}

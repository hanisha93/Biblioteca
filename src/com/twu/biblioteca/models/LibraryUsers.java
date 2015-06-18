package com.twu.biblioteca.models;

public class LibraryUsers {
    private String libraryId;
    private String password;

    public LibraryUsers(String libraryId, String password) {
        this.libraryId = libraryId;
        this.password =password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LibraryUsers that = (LibraryUsers) o;

        return libraryId.equals(that.libraryId) && password.equals(that.password);

    }

    public boolean matchUser(String libraryId, String password) {
        return (this.libraryId.equals(libraryId)) && (this.password.equals(password));
    }
}

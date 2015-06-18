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

        if (!libraryId.equals(that.libraryId)) return false;
        return password.equals(that.password);

    }
}

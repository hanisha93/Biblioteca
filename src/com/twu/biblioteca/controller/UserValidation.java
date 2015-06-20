package com.twu.biblioteca.controller;

import com.twu.biblioteca.models.LibraryUser;

import java.util.ArrayList;

public class UserValidation {

    private ArrayList<LibraryUser> libraryUsers;
    public UserValidation(ArrayList<LibraryUser> libraryUsers) {
        this.libraryUsers = libraryUsers;
    }

    public String validateUser(String libraryId, String password) {
        String role="";
        for (LibraryUser libraryUser : libraryUsers)
            role = libraryUser.matchUser(libraryId, password);
        return role;
    }

}

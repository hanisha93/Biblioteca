package com.twu.biblioteca.controller;

import com.twu.biblioteca.models.LibraryUser;

import java.util.ArrayList;

public class  UserValidation {

    private ArrayList<LibraryUser> libraryUsers;
    public UserValidation(ArrayList<LibraryUser> libraryUsers) {
        this.libraryUsers = libraryUsers;
    }

    public String  validateUser(String libraryId, String password) {
        String role = null;
        for (LibraryUser libraryUser : libraryUsers)
             if(libraryUser.matchUser(libraryId, password)) {
                 role = libraryUser.getRole();
                 break;
             }
        return role;
    }
}

package com.twu.biblioteca.controller;

import com.twu.biblioteca.Messages;
import com.twu.biblioteca.View;
import com.twu.biblioteca.models.Librarian;
import com.twu.biblioteca.models.LibraryUser;

import java.util.ArrayList;

import static com.twu.biblioteca.Messages.*;

public class UserValidation {

    private ArrayList<LibraryUser> libraryUsers;


    public UserValidation(ArrayList<LibraryUser> libraryUsers) {
        this.libraryUsers = libraryUsers;
    }

    public boolean validateUser(String libraryId, String password) {
        for (LibraryUser libraryUser : libraryUsers) {
            if (libraryUser.matchUser(libraryId, password)) return true;
        }
        return false;
    }
}

package com.twu.biblioteca.controller;

import com.twu.biblioteca.View;
import com.twu.biblioteca.models.Librarian;
import com.twu.biblioteca.models.LibraryUser;

import java.util.ArrayList;

public class UserValidation {
    private View view;
    private ArrayList<LibraryUser> libraryUsers;
    private LibraryUser libraryUser;

    public UserValidation(View view, ArrayList<LibraryUser> libraryUsers, LibraryUser libraryUser) {
        this.view =view;
        this.libraryUsers = libraryUsers;
        this.libraryUser = libraryUser;
    }


    public boolean validateUser() {
        String libraryId = view.readInput();
        String password = view.readInput();
        for(LibraryUser libraryUser : libraryUsers) {
            if(libraryUser.matchUser(libraryId, password)) return true;
        }
        return false;
    }
}

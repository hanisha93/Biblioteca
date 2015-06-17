package com.twu.biblioteca.models;

import com.twu.biblioteca.Item;
import com.twu.biblioteca.item.Movie;

import java.util.ArrayList;

public class Movies {

    private ArrayList<Item> moviesList;

    public Movies(ArrayList<Item> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public String toString() {
        String movieList = "";
        for (Item movie : moviesList) {
            movieList = movieList + "" + movie.toString() + "\n";
        }
        return movieList;
    }
}

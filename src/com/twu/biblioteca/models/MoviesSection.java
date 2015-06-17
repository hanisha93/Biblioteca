package com.twu.biblioteca.models;

import java.util.ArrayList;

public class MoviesSection {

    private ArrayList<Movie> moviesList;

    public MoviesSection(ArrayList<Movie> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public String toString() {
        String movieList = "";
        for (Movie movie : moviesList) {
            movieList = movieList + "" + movie.toString() + "\n";
        }
        return movieList;
    }
}

package com.twu.biblioteca.models;

public class Movie {
    private String name, year, director, rating;

    public Movie(String name, String year, String director, String rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return name + "  " + year + "  " + director + "  " + rating + "*";

    }

    public boolean matchMovie(String title) {
        if(this.name.equals(title) ) {
            return true;
        }
        return false;
    }
}

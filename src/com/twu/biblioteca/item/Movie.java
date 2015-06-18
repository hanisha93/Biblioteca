package com.twu.biblioteca.item;

import com.twu.biblioteca.Item;

public class Movie implements Item{
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

    @Override
    public boolean match(String title) {
        return this.name.equals(title);
    }
}

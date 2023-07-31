package sg.edu.rp.c346.id22012867.mymovies;

import android.util.Log;

import java.io.Serializable;

public class Movie implements Serializable {

    private int id;
    private String title;
    private String genre;
    private int year;
    private String rating;

    public Movie(int id, String title, String genre, int year, String rating) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String URLratings() {
        String defaultUrl = "https://www.imda.gov.sg/regulations-and-licensing-listing/content-standards-and-classification/standards-and-classification/films";
        switch (rating) {
            case "G":
            case "PG":
            case "PG13":
            case "NC16":
            case "M18":
            case "R21":
                return defaultUrl;
            default:
                return defaultUrl;
        }
    }

}

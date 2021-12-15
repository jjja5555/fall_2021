package edu.northeastern.martin;

import java.util.Date;
import java.util.List;

public class Movie {
    String title;
    Date releaseDate;
    String[] actorsAndDirectors;

    public Movie(String title, Date releaseDate, String [] actorsAndDirectors) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.actorsAndDirectors = actorsAndDirectors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String[] getActorsAndDirectors() {
        return actorsAndDirectors;
    }

    public void setActorsAndDirectors(String[] actorsAndDirectors) {
        this.actorsAndDirectors = actorsAndDirectors;
    }
}

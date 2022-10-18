package proj01;

import java.util.ArrayList;

public class Actor {

    private String name;
    private ArrayList<Movie> movies;

    public Actor (String new_name) {
        this.name = new_name;
    }

    public ArrayList<Movie> get_movies() {
        return movies;
    }
    public boolean add_movie(Movie movie)  {
        return false;
    }

}
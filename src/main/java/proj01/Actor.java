package proj01;

import java.util.ArrayList;

public class Actor {

    private int id;
    private String name;
    private ArrayList<Movie> movies = new ArrayList<>();

    public Actor (String name, int id) {
        this.name = name;
        this.id = id;
    }

    public ArrayList<Movie> get_movies() {
        return movies;
    }
    public boolean add_movie(Movie movie)  {
        if (this.movies.add(movie))
            return true;
        else
            return false;
    }

}
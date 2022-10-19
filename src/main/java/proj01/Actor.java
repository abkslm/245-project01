package proj01;

import java.util.ArrayList;

public class Actor implements Comparable<Actor> {

    private int id;
    private String name;
    private ArrayList<Movie> movies = new ArrayList<>();

    public Actor (String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int get_id() {
        return this.id;
    }
    public String get_name() {
        return this.name;
    }

    public ArrayList<Movie> get_movies() {
        return movies;
    }
    public boolean add_movie (Movie movie)  {
        if (this.movies.add(movie))
            return true;
        else
            return false;
    }

    @Override
    public int compareTo (Actor o) {
        return this.id - o.id;
    }
}
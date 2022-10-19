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

    public void print() {
        StringBuilder sb = new StringBuilder();
        for (Movie movie : this.movies) {
            sb.append("* Movie: ");
            sb.append(movie.get_title());
            sb.append(" as ");
            sb.append(movie.get_char());
            System.out.println(sb.toString());

            sb = new StringBuilder();
        }
    }

}
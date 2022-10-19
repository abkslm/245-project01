package proj01;

import java.util.ArrayList;

/**
 * A class to hold each actor's data, along with their respective movies.
 */

public class Actor {

    private final int id;
    private final String name;
    private final ArrayList<Movie> movies = new ArrayList<>();

    public Actor (String name, int id) {
        this.name = name;
        this.id = id;
    }

    /**
     * Getter for an Actor's id
     * @return -> An int, the desired Actor's id.
     */
    public int get_id() {
        return this.id;
    }

    /**
     * Getter for an Actor's name
     * @return -> A string, the desired Actor's name.
     */
    public String get_name() {
        return this.name;
    }

    /**
     * A getter for the Movie list within an Actor
     * @return -> An ArrayList of Movies, those belonging to the Actor
     */
    public ArrayList<Movie> get_movies() {
        return movies;
    }

    /**
     * Adds a Movie to the Actor's Movie ArrayList
     * @param movie -> Movie object to be added to Movie ArrayList
     */
    public void add_movie (Movie movie)  {
        this.movies.add(movie);
    }

    /**
     * Void function to print an Actor's movie wall.
     */
    public void print() {
        StringBuilder sb = new StringBuilder();
        for (Movie movie : this.movies) {
            sb.append("* Movie: ");
            sb.append(movie.get_title());
            sb.append(" as ");
            sb.append(movie.get_char());

            System.out.println(sb);
            sb = new StringBuilder();
        }
    }

}
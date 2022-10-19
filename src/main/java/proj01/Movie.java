package proj01;

/**
 * A container class for Movie data
 */

public class Movie {

    private final String title;
    private final String character;

    public Movie (String new_title, String new_character) {
        this.title = new_title;
        this.character = new_character;
    }

    /**
     * A getter for a Movie's title.
     * @return -> A String, the Movie's title datum.
     */
    public String get_title() {
        return this.title;
    }

    /**
     * A getter for an Actor's character within a Movie.
     * @return -> A String, the name of the desired Actor's character in a Movie.
     */
    public String get_char() {
        return this.character;
    }


}
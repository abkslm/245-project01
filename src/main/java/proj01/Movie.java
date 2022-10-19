package proj01;

public class Movie {

    private String title;
    private String character;

    public Movie (String new_title, String new_character) {
        this.title = new_title;
        this.character = new_character;
    }


    public void sort_movies() {

    }

    public String get_title() {
        return this.title;
    }

    public String get_char() {
        return this.character;
    }


}
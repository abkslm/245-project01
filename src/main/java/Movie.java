public class Movie {

    private String title;
    private String role;
    private String character;

    public Movie (String new_title, String new_role, String new_character) {
        this.title = new_title;
        this.role = new_role;
        this.character = new_character;
    }

    public Movie (String new_title, String new_role) {
        this.title = new_title;
        this.role = new_role;

    }

    public String get_title() {
        return this.title;
    }
    public String get_role() {
        return this.role;
    }
    public String get_char() {
        return this.character;
    }


}
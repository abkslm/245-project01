package proj01;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


/**
 * This class, as you may expect, parses, taking an input from the FileHandler, then doing its thing.
 */

public class Parser {
    static final int NAME = 2;
    static final int CHAR = 3;
    static final int ID = 4;




    public Parser() {}

    /**
     * Parses CSV via helper functions.
     * @param reader -> a BufferedReader provided by FileHandler
     * @throws IOException -> In case the reader has an aneurysm
     */
    public void parse_csv (BufferedReader reader) throws IOException {
        String line;
        reader.readLine();
        while ((line = reader.readLine()) != null) {
            String title = parse_title(line);
            ArrayList<String> data = parse_data(line);
            parse_cast(data, title);
        }
    }

    /**
     * Parses the cast data, within the "data" field (garbage in json clothing)
     * @param cast -> String containing entire cast column.
     * @param movie_title -> Movie title, used to create actors and their movies.
     */
    public void parse_cast (ArrayList<String> cast, String movie_title) {
        for (String member : cast) {
            if (member.contains("cast")) {
                int id = Integer.parseInt(Objects.requireNonNull(use_regex(member, ID)));
                String name = use_regex(member, NAME);
                String character = use_regex(member, CHAR);

                Actor actor = new Actor(name, id);
                actor.add_movie(new Movie(movie_title, character));
                Driver.actors.attach(actor);
            }
        }
    }

    /**
     * Parses/gets the title from the current line within the file.
     * @param in_str -> A string containing the entire line mentioned above.
     * @return -> Returns the title of the movie.
     */
    private String parse_title (String in_str) {
        int commas_found = 0;
        int quotes_found = 0;
        final int comma_max = 2;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < in_str.length() && commas_found <= comma_max; i++) {
            char prev_ch;
            char curr_ch = in_str.charAt(i);
            if (i > 0) prev_ch = in_str.charAt(i - 1);
            else prev_ch = ' ';

            boolean allow_by_quote = (quotes_found == 1);

            if (curr_ch == ',' && !allow_by_quote && prev_ch != '\\') {
                commas_found++;
            } else if (curr_ch == '"' && prev_ch != '\\') {
                quotes_found++;
            } else if (commas_found == 1) {
                sb.append(curr_ch);
            }
        }
        return sb.toString();
    }

    /**
     *
     * @param in_str -> A string containing the current line within the file.
     * @return -> Returns an ArrayList of Strings, containing each cast member's cell per node.
     */
    private ArrayList<String> parse_data (String in_str){
        int brackets_found = 0;
        final int bracket_max = 2;
        StringBuilder sb = new StringBuilder();
        ArrayList<String> data = new ArrayList<>();

        for (int i = 0; (i < in_str.length()) && (brackets_found <= bracket_max); i++) {
            char curr_ch = in_str.charAt(i);
            if (curr_ch == '{' || curr_ch == '}') {
                brackets_found++;
            } else if (brackets_found == 1){
                sb.append(curr_ch);
            } else if (brackets_found == 2) {
                data.add(sb.toString());
                sb = new StringBuilder();
                brackets_found = 0;
            }
        }
        return data;
    }

    /**
     * Allows needed actor data to be pulled via regex.
     * @param input -> String to be parsed with regex
     * @param key -> A constant of sorts, allows specification of which datum is needed.
     * @return -> Returns the requested extracted String.
     */
    public static String use_regex (String input, int key) {
        Pattern pattern = null;
        if (key == NAME) {
            pattern = Pattern.compile("\"\"name\"\": \"\"(.*?)\"\"", Pattern.CASE_INSENSITIVE);
        } else if (key == CHAR) {
            pattern = Pattern.compile("\"\"character\"\": \"\"(.*?)\"\"", Pattern.CASE_INSENSITIVE); //original working line
        } else if (key == ID) {
            pattern = Pattern.compile("\"\"id\"\": (.*?),", Pattern.CASE_INSENSITIVE);
        }

        if (pattern != null) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                return matcher.group(1);
            }
        } return null;
    }
}

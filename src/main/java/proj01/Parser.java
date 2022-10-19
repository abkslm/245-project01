package proj01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;




public class Parser {
    static final int TITLE = 0;
    static final int DATA = 1;
    static final int NAME = 2;
    static final int CHAR = 3;
    static final int ID = 4;

    //ArrayList<String> titles = new ArrayList<>();
    //ArrayList<ArrayList<String>> data = new ArrayList<>();


    public Parser() {}

    public void parse_csv (BufferedReader reader) throws IOException {
        String line;
        int i = 0;
        reader.readLine();
        while ((line = reader.readLine()) != null) {
            String title = parse_title(line);
            ArrayList<String> data = parse_data(line);
            parse_cast(data, title);

        }
    }


    public void parse_cast (ArrayList<String> cast, String movie_title) {
        for (String member : cast) {
            if (member.contains("cast")) {
                //System.out.println("Parsing member: " + member);
                int id = Integer.parseInt(use_regex(member, ID));
                String name = use_regex(member, NAME);
                String character = use_regex(member, CHAR);

                Actor actor = new Actor(name, id);
                actor.add_movie(new Movie(movie_title, character));
                main.actors.attach(actor);
            }
        }
    }


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

    // Parses data within the {} blocks, gives each block its own string. Returns arraylist of all resp. strings.
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
                brackets_found = 0;
            }
        }
        return data;
    }

    public static String use_regex (String input, int key) {
        String test_string = new String("{\"\"\"cast_id\"\": 242, \"\"character\"\": \"\"Jake Sully\"\", \"\"credit_id\"\": \"\"5602a8a7c3a3685532001c9a\"\", \"\"gender\"\": 2, \"\"id\"\": 65731, \"\"name\"\": \"\"Sam Worthington\"\", \"\"order\"\": 0}");
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
                            matcher.find();
            String output = matcher.group(1);
            return output;
        } else return null;

//        Matcher matcher = pattern.matcher(input);
//        System.out.println(matcher.find());
//        String output = matcher.group(1);
//        System.out.println(output);
//        return null;
    }









}

package proj01;

import java.io.InputStream;
import java.util.ArrayList;

public class Parser {

    //TODO: Implement

    public Parser() {}

    public static void parse_json (String[] str_arr) {

    }

    public static ArrayList<String[]> parse_csv (String csv_str) {
        final int max_commas = 2;
        int seen_commas = 0;
        StringBuilder title_sb = new StringBuilder();
        StringBuilder cast_sb = new StringBuilder();
        for (int i = 0; i < csv_str.length() && seen_commas <= max_commas; i++) {
            char curr_ch = csv_str.charAt(i);
            boolean is_alpha = Character.isAlphabetic(curr_ch);
            if (curr_ch == ',') {
                seen_commas++;
            } else if (seen_commas == 1 && is_alpha) {
                title_sb.append(csv_str.charAt(i));
            } else if (seen_commas == 2 && is_alpha) {
                cast_sb.append(csv_str.charAt(i));
            }
        }
        return null;
    }







}

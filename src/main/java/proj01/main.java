package proj01;

import com.opencsv.exceptions.CsvException;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

// VERY IMPORTANT -> Provided CSV file is malformed, added a _"_ to the end to fix it.

public class main {

    public ArrayList<Actor> actors = new ArrayList<>();

    public static void main(String[] args) throws IOException, CsvException, ParseException {

        //FileHandler fileHandler = new FileHandler("src/main/tmdb_5000_credits.csv");
        //ArrayList<String[]> lines = fileHandler.read_file();
        //Parser.use_regex();

    }
}

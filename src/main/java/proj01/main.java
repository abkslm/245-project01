package proj01;

import com.opencsv.exceptions.CsvException;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

public class main {

    public static ActorHandler actors = new ActorHandler();
    public static void main(String[] args) throws IOException, CsvException, ParseException {

        FileHandler fileHandler = new FileHandler("src/main/tmdb_5000_credits.csv");
        for (int i = 0; i < actors.length(); i++) {
            System.out.println(actors.get_by_index(i).get_name());
        }
        System.out.println("Initialized " + actors.length() + " actors.");




    }
}

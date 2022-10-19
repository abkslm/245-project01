package proj01;

import java.io.*;
import java.nio.CharBuffer;
import java.util.ArrayList;


public class FileHandler {

    // Constant array indices, used in accessing CSVReader output
    static final int TITLE = 0;
    static final int CAST = 1;

    private BufferedReader reader;


    public FileHandler(String file_path) throws IOException {
        FileInputStream file = new FileInputStream(file_path);
        InputStreamReader in_stream = new InputStreamReader(file, "UTF-8");
        this.reader = new BufferedReader(in_stream);
        this.read();
        }

    public ArrayList<String[]> read() throws IOException {
        Parser parser = new Parser();
        parser.parse_csv(this.reader);

        return null;
        // call read_csv, save to array list. <> is each movie, [] 0 is movie title, 1 is data for an individual actor.

    }
}



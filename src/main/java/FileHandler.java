import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class FileHandler {

    // Constant array indices, used in accessing CSVReader output
    static final int YEAR = 0;
    static final int MOVIE = 1;
    static final int CAST = 2;

    private InputStream in_stream;
    private CSVReader reader;


    public FileHandler(String file_path) throws UnsupportedEncodingException {
        this.in_stream = main.class.getClassLoader().getResourceAsStream(file_path);
        this.reader = new CSVReaderBuilder(new InputStreamReader(in_stream, "UTF-8")).withSkipLines(1).build();
    }

    public ArrayList<String[]> read_file () throws CsvException, IOException {
        ArrayList<String[]> credit_lines = new ArrayList<>();
        String[] credit_line = this.reader.readNext();
        while (credit_line != null) {
            credit_lines.add(credit_line);
            credit_line = this.reader.readNext();
        }
        return credit_lines;
    }

}

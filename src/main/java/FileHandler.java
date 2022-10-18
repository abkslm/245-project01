import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Arrays;


public class FileHandler {

    // Constant array indices, used in accessing CSVReader output
    static final int YEAR = 0;
    static final int MOVIE = 1;
    static final int CAST = 2;

    private InputStream in_stream;
    private Reader reader;

    private CharBuffer buf = CharBuffer.allocate(10000);


    public FileHandler(String file_path) throws UnsupportedEncodingException {
        this.in_stream = main.class.getClassLoader().getResourceAsStream(file_path);
        this.reader = new InputStreamReader(this.in_stream, "UTF-8");
        }

    public void read() throws IOException {
        byte[] bytes = this.in_stream.readAllBytes();
        String str = new String(bytes);
        for (int i = 0; i < str.length(); i++) {

        }

    }
}



package proj01;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * This class handles the provided file (as the name alludes to).
 * After reading the file into a buffer, it calls the parser to manipulate/deal with the contents
 */

public class FileHandler {

    private final BufferedReader reader;

    /**
     *
     * @param file_path -> File path provided in Driver.main(args[0]).
     * @throws IOException -> Must throw exception, handled in Driver.main().
     */
    public FileHandler(String file_path) throws IOException {
        FileInputStream file = new FileInputStream(file_path);
        InputStreamReader in_stream = new InputStreamReader(file, StandardCharsets.UTF_8);
        this.reader = new BufferedReader(in_stream);
    }

    /**
     * A void function, handles contents of the datafile, then hands off to the parser.
     */
    public void read() {
        System.out.println("Reading file...");
        Parser parser = new Parser();
        try {
            parser.parse_csv(this.reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Done.");
    }
}



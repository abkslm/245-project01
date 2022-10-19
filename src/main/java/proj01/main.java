package proj01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static ActorHandler actors = new ActorHandler();
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("You must specify a file at launch!");
            System.exit(-1);
        }

        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler(args[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Successfully loaded in datafile...");
        fileHandler.read();
        actors.sort();

        System.out.println("Welcome to the Hell-to-Build Wall!");
        System.out.println("Type \"quit\" to exit");
        Scanner in = new Scanner(System.in);
        boolean running = true;
        while (running) {
            String line = in.nextLine();
            if (line.toLowerCase().equals("quit") || line == "\r") running = false;

            else {
                int index = actors.search(line);
                Actor requested_actor = actors.get_by_index(index);
                if (requested_actor.get_name().to()

                System.out.println("Showing results for: " + requested_actor.get_name());
                requested_actor.print();
                System.out.println("Would you like to search for another actor? Or \"quit\"?");
            }
        }
    }
}

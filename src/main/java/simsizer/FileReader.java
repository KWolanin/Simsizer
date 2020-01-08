package simsizer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

    public static void readFile(String name, String location, ArrayList<String> type) throws FileNotFoundException {
        String patch = "src/main/resources/" + location + "/" + name + ".txt";
        File traitList = new File(patch);
        Scanner in = new Scanner(traitList);
        while (in.hasNextLine()) {
            writeToList(in, type);
        }
        in.close();
    }

    public static void writeToList(Scanner in, ArrayList<String> type) {
        String line = in.nextLine();
        type.add(line);
    }

}

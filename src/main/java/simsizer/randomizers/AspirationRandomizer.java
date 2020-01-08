package simsizer.randomizers;

import simsizer.FileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AspirationRandomizer {

    public static final ArrayList<String> aspirations = new ArrayList<>();
    public static String aspirationMsg;

    private static void removeChildAspirations() throws FileNotFoundException {
        String patch = "src/main/resources/aspirations/Children.txt";
        File aspirationList = new File(patch);
        Scanner in = new Scanner(aspirationList);
        while (in.hasNextLine()) {
            String unnecessaryChildAspirations = in.nextLine();
            aspirations.remove(unnecessaryChildAspirations);
        }
        in.close();
    }

    public static String randomizeAspiration() {
        Random random = new Random();
        int i = random.nextInt(aspirations.size());
        return aspirations.get(i);
    }

    public static void randomizeChildAspiration() throws FileNotFoundException {
        aspirations.clear();
        FileReader.readFile("Children", "aspirations", aspirations);
        aspirationMsg = randomizeAspiration();
    }

    public static void randomizeAdultAspiration() throws FileNotFoundException {
        removeChildAspirations();
        aspirationMsg = randomizeAspiration();
    }

}

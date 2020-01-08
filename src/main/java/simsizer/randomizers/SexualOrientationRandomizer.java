package simsizer.randomizers;

import simsizer.FileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class SexualOrientationRandomizer {

    public static final ArrayList<String> orientation = new ArrayList<>();

    public static String randomizeOrientation() throws FileNotFoundException {
        FileReader.readFile("orientation", "", orientation);
        Random random = new Random();
        int i = random.nextInt(orientation.size() - 1);
        return orientation.get(i);
    }


}

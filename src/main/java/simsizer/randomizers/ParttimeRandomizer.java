package simsizer.randomizers;

import simsizer.FileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class ParttimeRandomizer {

    public static final ArrayList<String> parttimejobs = new ArrayList<>();
    public static String parttimeMsg;

    public static String randomizeParttimeJob() {
        Random random = new Random();
        int i = random.nextInt(parttimejobs.size());
        return parttimejobs.get(i);
    }

    public static void randomizeTeenParttimeJob() throws FileNotFoundException {
        parttimejobs.clear();
        FileReader.readFile("BaseGame", "parttimejobs", parttimejobs);
        parttimeMsg = randomizeParttimeJob();
    }

    public static void randomizeAdultParttimeJob() throws FileNotFoundException {
        parttimejobs.clear();
        FileReader.readFile("BaseGame", "parttimejobs", parttimejobs);
        FileReader.readFile("IslandLiving", "parttimejobs", parttimejobs);
        parttimeMsg = randomizeParttimeJob();
    }

}

package simsizer.randomizers;

import java.util.ArrayList;
import java.util.Random;

public class FulltimeRandomizer {

    public static final ArrayList<String> fulltimeJob = new ArrayList<>();

    public static String randomizeFulltimeJob() {
        Random random = new Random();
        int i = random.nextInt(fulltimeJob.size());
        return fulltimeJob.get(i);
    }
}

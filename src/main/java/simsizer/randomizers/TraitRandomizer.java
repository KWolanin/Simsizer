package simsizer.randomizers;

import simsizer.FileReader;
import simsizer.controllers.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class TraitRandomizer {

    public static final ArrayList<String> traits = new ArrayList<>();
    public static String traitMsg;

    private static void removeToddlerTraits() throws FileNotFoundException {
        String patch = "src/main/resources/traits/Toddler.txt";
        File traitList = new File(patch);
        Scanner in = new Scanner(traitList);
        while (in.hasNextLine()) {
            String unnecessaryToddlerTraits = in.nextLine();
            traits.remove(unnecessaryToddlerTraits);
        }
        in.close();
    }

    public static void randomizeAdultTraits() throws FileNotFoundException {
        removeToddlerTraits();
        switch (Controller.traitAmountForRandomize) {
            case 1:
                traitMsg = randomizeTrait();
                break;
            case 2:
                traitMsg = randomizeTrait() + ", " + randomizeTrait();
                break;
            case 3:
                traitMsg = randomizeTrait() + ", " + randomizeTrait() + ", " + randomizeTrait();
                break;
            default:
        }
    }

    public static void randomizeToddlerTraits() throws FileNotFoundException {
        traits.clear();
        FileReader.readFile("Toddler", "traits", traits);
        traitMsg = randomizeTrait();
    }

    private static String randomizeTrait() {
        Random random = new Random();
        int i = random.nextInt(traits.size());
        return traits.get(i);
    }
}

package simsizer;

import simsizer.randomizers.AspirationRandomizer;
import simsizer.randomizers.FulltimeRandomizer;
import simsizer.randomizers.ParttimeRandomizer;
import simsizer.randomizers.TraitRandomizer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static simsizer.FileReader.readFile;

public class DLCSelector {

    public static void loadSelectedDLCs() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/my.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);
        if (properties.getProperty("CatsnDogs").equals("true")) {
            readFile("Cats&Dogs", "traits", TraitRandomizer.traits);
            FileReader.readFile("Cats&Dogs", "aspirations", AspirationRandomizer.aspirations);
        }
        if (properties.getProperty("CityLiving").equals("true")) {
            FileReader.readFile("CityLiving", "traits", TraitRandomizer.traits);
            FileReader.readFile("CityLiving", "aspirations", AspirationRandomizer.aspirations);
            FileReader.readFile("CityLiving", "fulltimejobs", FulltimeRandomizer.fulltimeJob);

        }
        if (properties.getProperty("GetFamous").equals("true")) {
            FileReader.readFile("GetFamous", "traits", TraitRandomizer.traits);
            FileReader.readFile("GetFamous", "aspirations", AspirationRandomizer.aspirations);
            FileReader.readFile("GetFamous", "fulltimejobs", FulltimeRandomizer.fulltimeJob);

        }
        if (properties.getProperty("GetTogether").equals("true")) {
            FileReader.readFile("GetTogether", "traits", TraitRandomizer.traits);
            FileReader.readFile("GetTogether", "aspirations", AspirationRandomizer.aspirations);
        }
        if (properties.getProperty("IslandLiving").equals("true")) {
            FileReader.readFile("IslandLiving", "traits", TraitRandomizer.traits);
            FileReader.readFile("IslandLiving", "aspirations", AspirationRandomizer.aspirations);
            FileReader.readFile("IslandLiving", "fulltimejobs", FulltimeRandomizer.fulltimeJob);
            FileReader.readFile("IslandLiving", "parttimejobs", ParttimeRandomizer.parttimejobs);

        }
        if (properties.getProperty("OutdoorRetreat").equals("true")) {
            FileReader.readFile("OutdoorRetreat", "traits", TraitRandomizer.traits);
            FileReader.readFile("OutdoorRetreat", "aspirations", AspirationRandomizer.aspirations);
        }
        if (properties.getProperty("Strangerville").equals("true")) {
            FileReader.readFile("StrangerVille", "traits", TraitRandomizer.traits);
            FileReader.readFile("StrangerVille", "aspirations", AspirationRandomizer.aspirations);
            FileReader.readFile("StrangerVille", "fulltimejobs", FulltimeRandomizer.fulltimeJob);

        }
        if (properties.getProperty("DiscoverUniversity").equals("true")) {
            FileReader.readFile("DiscoverUniversity", "traits", TraitRandomizer.traits);
            FileReader.readFile("DiscoverUniversity", "aspirations", AspirationRandomizer.aspirations);
            FileReader.readFile("DiscoverUniversity", "fulltimejobs", FulltimeRandomizer.fulltimeJob);
        }
        if (properties.getProperty("JungleAdventures").equals("true")) {
            FileReader.readFile("JungleAdventures", "traits", TraitRandomizer.traits);
            FileReader.readFile("JungleAdventures", "aspirations", AspirationRandomizer.aspirations);
        }
        if (properties.getProperty("Parenthood").equals("true")) {
            FileReader.readFile("Parenthood", "traits", TraitRandomizer.traits);
            FileReader.readFile("Parenthood", "aspirations", AspirationRandomizer.aspirations);
        }
        if (properties.getProperty("RealmOfMagic").equals("true")) {
            FileReader.readFile("RealmOfMagic", "traits", TraitRandomizer.traits);
            FileReader.readFile("RealmOfMagic", "aspirations", AspirationRandomizer.aspirations);
        }
        if (properties.getProperty("Vampires").equals("true")) {
            FileReader.readFile("Vampires", "traits", TraitRandomizer.traits);
            FileReader.readFile("Vampires", "aspirations", AspirationRandomizer.aspirations);
        }
        if (properties.getProperty("GetToWork").equals("true")) {
            FileReader.readFile("GetToWork", "fulltimejobs", FulltimeRandomizer.fulltimeJob);
        }
        if (properties.getProperty("Moshino").equals("true")) {
            FileReader.readFile("Moshino", "fulltimejobs", FulltimeRandomizer.fulltimeJob);
        }
        if (properties.getProperty("Seasons").equals("true")) {
            FileReader.readFile("Seasons", "fulltimejobs", FulltimeRandomizer.fulltimeJob);
        }
    }

    public static void mergeSelectedDLC() throws IOException {
        FileReader.readFile("BaseGame", "traits", TraitRandomizer.traits);
        FileReader.readFile("BaseGame", "aspirations", AspirationRandomizer.aspirations);
        FileReader.readFile("BaseGame", "fulltimejobs", FulltimeRandomizer.fulltimeJob);
        FileReader.readFile("BaseGame", "parttimejobs", ParttimeRandomizer.parttimejobs);
        DLCSelector.loadSelectedDLCs();
    }
}

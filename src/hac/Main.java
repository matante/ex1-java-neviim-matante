package hac;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

/**
 * This is the main class of the program, containing the main function.
 */
public class Main {

    /**
     * This is the main function of the program, it gets its arguments in the args variable
     * @param args a variable with the information regarding the tags, url, output file
     * @throws IOException in case of a sudden error
     */
    public static void main(String[] args) throws IOException {
        Globals globals = Globals.getInstance(); // a singleton of global const variable

        Validator validator = new Validator();

        // make sure input is ok

        try{
            validator.isEnoughArgs(args);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        // args are ok, check their value

        char[] chars = args[globals.valueOf("tag")].toCharArray(); // the tags asked
        String url = args[globals.valueOf("url")]; // the url to work on

        try{
            validator.isValidTags(chars);
            validator.isValidURL(url);
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        // values are ok, connection is ok, let's scrap!!!

        Scrapper basicScrapper = new BasicScrapper(); // the scrapper which on the other scrappers rely on

        for (int i = globals.valueOf(globals.getPrefix()) + 1; i < chars.length; i++) { // start from 2nd cell, index 1
            switch (chars[i]) {
                case 'a' -> basicScrapper = new Links(basicScrapper);
                case 'h' -> basicScrapper = new h1Titles(basicScrapper);
                case 'i' -> basicScrapper = new Images(basicScrapper);
            }
        }

        Document doc = Jsoup.connect(url).get();
        String fileName = args[globals.valueOf("fileName")]; // the output file

        basicScrapper.scrap(doc, fileName); // after all layers added, go scrap
    }

}

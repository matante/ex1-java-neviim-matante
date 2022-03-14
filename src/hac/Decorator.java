package hac;

import org.jsoup.nodes.Document;
import java.io.IOException;

/**
 * this class is a Decorator which builds the layers for the scrappers
 */
public class Decorator implements Scrapper {
    /**
     * an instance of the Scrapper that is "building" on
     */
    protected Scrapper levelBelow;

    /**
     * a constructor
     * @param levelBelow is another instance of another scraper, make it "ours"
     */
    public Decorator(Scrapper levelBelow) {
        this.levelBelow = levelBelow;
    }

    /**
     * the decorating function, used to "travel" between the "decorations" of the basic scrapper
     * @param doc same as described in Scrapper
     * @param fileName same as described in Scrapper
     */
    @Override
    public void scrap(Document doc, String fileName) {
        levelBelow.scrap(doc, fileName);
    }
}

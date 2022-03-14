package hac;

import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * This is the lowest level of a Scrapper. More levels of data written upon it.
 */
public class BasicScrapper implements Scrapper{
    /**
     the scrap function, which used to scrap data (a website) to a file. here it does nothing, but
     the "children" of this class used it (decorators).
     * @param doc a Document which is an HTML
     * @param fileName a file the results are written into
     */
    @Override
    public void scrap(Document doc, String fileName){
    }
}
package hac;

import org.jsoup.nodes.Document;
import java.io.IOException;

/**
 * This is an interface which used for scrapping data from sites.
 * It has the scrap function which gets an url and a file name, and scraps the data to this file
 */
public interface Scrapper {
    /**
     the scrap function, which used to scrap data (a website) to a file.
     * @param doc a Document which is an HTML
     * @param fileName a file teh results are written into
     */
    void scrap(Document doc, String fileName) ;
}
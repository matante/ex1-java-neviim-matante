package hac;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.io.IOException;

/**
 * a class to handle "a" requests (links (href) in html)
 */
public class Links extends Decorator {

    /**
     * a constructor
     * @param levelBelow another Scrapper  which was called previously
     *                   (like a plain pizza, which then add olives or sauce etc.)
     */

    public Links(Scrapper levelBelow) {
        super(levelBelow);
    }


    /**
     * for each image element in the html, print its link to the file
     * @param doc same as described in Scrapper
     * @param fileName same as described in Scrapper
     */
    @Override
    public void scrap(Document doc, String fileName) {
        try (FileWriter fw = new FileWriter(fileName, true)) {
            Elements links = doc.select("a");

            for (Element link : links) {
                fw.write(link.attr("abs:href") + "\n");
            }
            fw.write("\n");
            super.scrap(doc, fileName);

        } catch (IOException e) {
            System.out.println("error");
        }

    }


}

package hac;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.io.IOException;

/**
 * a class to handle "img" requests (images in html)
 */
public class Images extends Decorator {
    /**
     * a constructor
     * @param levelBelow another Scrapper  which was called previously
     *                   (like a plain pizza, which then add olives or sauce etc.)
     */
    public Images(Scrapper levelBelow) {
        super(levelBelow);
    }

    /**
     * for each image element in the html, print its link to the file
     * @param doc same as described in Scrapper
     * @param fileName same as described in Scrapper
     */
    @Override
    public void scrap(Document doc, String fileName)  {
        try (FileWriter fw = new FileWriter(fileName, true)) {
            Elements images = doc.select("img");
            for (Element image : images) {
                fw.write(image.attr("abs:src") + "\n");//appends the string to the file
            }
            fw.write("\n");
            super.scrap(doc, fileName);

        } catch (IOException e) {
            System.out.println("error");
        }
    }
}

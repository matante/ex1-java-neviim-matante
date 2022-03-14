package hac;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.io.IOException;

/**
 * a class to handle "h" requests (h1 titles in html)
 */
public class h1Titles extends Decorator {

    /**
     * a constructor
     * @param levelBelow another Scrapper  which was called previously
     *                   (like a plain pizza, which then add olives or sauce etc.)
     */
    public h1Titles(Scrapper levelBelow) {
        super(levelBelow);
    }

    /**
     * for each h1 element in the html, print it to the file
     * @param doc same as described in Scrapper
     * @param fileName same as described in Scrapper
     */
    @Override
    public void scrap(Document doc, String fileName){
        try (FileWriter fw = new FileWriter(fileName, true)) {
            Elements headers = doc.select("h1");
            for (Element header : headers) {
                fw.write(header.text() + "\n");//appends the string to the file
            }
            fw.write("\n");
            super.scrap(doc, fileName);

        } catch (IOException e) {
            System.out.println("error");
        }
    }
}

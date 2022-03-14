package hac;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

/**
 * this class used to validate the input
 */
public class Validator{

    /**
     * the number of arguments we agree to receive, tags + url + file name
     */
    private final static int EXPECTED_NUM_OF_ARGS = 3;

    /**
     * a map for exceptions
     */
    private final static Map<String, String> exceptions = new HashMap<>();

    /**
     * a c'tor which adds some data to the map
     */
    public Validator() {
        exceptions.put("BAD_ARGS", "invalid command");
        exceptions.put("BAD_URL", "bad url");
    }

    /**
     * a function that checks if a URL is valid and if the page is an HTML page
     * @param url the url as String as we got it from the args
     */
    public void isValidURL(String url) {

        try { // try to make a connection and check if the file is an HTML page
            URL urlToCheck = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlToCheck.openConnection();
            connection.connect();
            urlToCheck.toURI();


            String type = connection.getHeaderField("Content-Type");
            if (!type.endsWith("html")){
                throw new IllegalArgumentException(exceptions.get("BAD_URL"));
            }

        } catch (Exception e) {
            throw new IllegalArgumentException( exceptions.get("BAD_URL"));
        }
    }

    /**
     * a function that checks if the tags from the input appears in the acceptable tags
     * @param chars an array of characters which contains characters to check
     */
    public void isValidTags(char[] chars) {

        Globals globals = Globals.getInstance(); // singleton

        if (chars[globals.valueOf(globals.getPrefix())] != globals.getPrefix()
                // same as args[0][0] != '-' but with constants
                || chars.length < globals.valueOf("minimalSize")) // less than 2, "-" and a tag
        {
            throw new IllegalArgumentException(exceptions.get("BAD_ARGS"));
        }

        ScrappersFactory tagsFactory = new ScrappersFactory();
        List<Character> acceptableTags = tagsFactory.getAcceptableTags(); // a list of the acceptable tags

        for (int i = globals.valueOf("prefix") + 1; i < chars.length; i++) { // start from index 1
            if (!acceptableTags.contains(chars[i])) // char from input not found
                throw new IllegalArgumentException(exceptions.get("BAD_ARGS"));
        }
    }

    /**
     * used to check if right amount of args delivered
     * @param args as described above
     */
    public void isEnoughArgs(String[] args) {
        if (args.length != EXPECTED_NUM_OF_ARGS) { // 3 as described above
            throw new IllegalArgumentException(exceptions.get("BAD_ARGS"));
        }
    }

}

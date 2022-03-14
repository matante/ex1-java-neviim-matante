package hac;

import java.util.HashMap;
import java.util.Map;

/**
 * this class serves as a macros class, similar to c/c++ macros. it is a singleton
 */
public class Globals {

    /**
     * our private instance of this class
     */
    private static Globals single_instance = null;

    /**
     * a map to hold the values of the constants integers
     */
    private final static Map<String, Integer> strings = new HashMap<>();

    /**
     * a private constructor for the singleton. it initializes the values in the map
     */
    private Globals() {
        strings.put("tag", 0);
        strings.put("url", 1);
        strings.put("fileName", 2);
        strings.put("minimalSize", 2);
        strings.put("prefix", 0);
        strings.put("-", 0);
    }


    /**
     * return a value of a constant
     * @param key String such as "url"
     * @return its constant value as an Integer
     */
    public Integer valueOf(String key) {
        return strings.get(key);
    }

    /**
     * same as the valueOf but for Characters, it just casts the Character to a string and then calls the previous function.
     * @param key a Character such as '-' , which is being cast to String
     * @return its constant value as an Integer
     */
    public Integer valueOf(Character key) {
        return valueOf(String.valueOf(key));
    }

    /**
     * a function to get the prefix, in case there will be a need to change it
     * @return the prefix as a Character
     */
    public Character getPrefix() {
        return '-';
    }

    /**
     * the function to call in case there is a need to use this singleton
     * @return a reference to this singleton
     */
    public static Globals getInstance() {
        if (single_instance == null)
            single_instance = new Globals();

        return single_instance;
    }
}

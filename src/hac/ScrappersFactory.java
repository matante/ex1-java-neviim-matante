package hac;

import java.util.ArrayList;
import java.util.List;

/**
 * a class which holds all the acceptable tags the user can use.
 * currently, only a, h, i accepted
 */
public class ScrappersFactory {

    /**
     * a list to hold all the accepted tags, as Character
     */
    private static final List<Character> acceptableTags = new ArrayList<>();

    /**
     * a constructor which adds the tags to the list
     */
    public ScrappersFactory(){
        acceptableTags.add('a');
        acceptableTags.add('h');
        acceptableTags.add('i');
    }

    /**
     * a function which used to get the list of the tags
     * @return the list of the tags
     */
    public List<Character> getAcceptableTags(){
        return acceptableTags;
    }

}

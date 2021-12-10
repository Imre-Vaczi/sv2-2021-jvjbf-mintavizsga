package uniquefinder;

import java.util.ArrayList;
import java.util.List;

public class UniqueFinder {

    public List<Character> getUniqueChars(String word) {
         if (word == null) {
            throw new IllegalArgumentException("Text is null.");
        } else {
             List<Character> resultChars = new ArrayList<>();
             char[] charArray = word.toCharArray();
             for (Character character : charArray) {
                 if (!resultChars.contains(character)) {
                     resultChars.add(character);
                 }
             }
             return resultChars;
         }
    }
}

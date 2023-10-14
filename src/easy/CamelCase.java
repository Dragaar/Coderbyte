package easy;
/**
  Have the function CamelCase(str) take the str parameter being passed
  and return it in proper camel case format where the first letter
  of each word is capitalized (excluding the first letter).
  ---
  The string will only contain letters and some combination of delimiter
  punctuation characters separating each word.
  For example: if str is "BOB loves-coding" then your program
  should return the string bobLovesCoding.
 */

public class CamelCase {

     private static String capitalize(String str) {
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    private static String[] splitWords(String str) {
        return str.split("[\\W_]+");

       /* ver 2 Without empty words
                return str
                .replaceAll("[^a-zA-Z]+", " ")
                .trim()
                .split("\\s+");*/
    }

    private static String camelCase(String str) {
        StringBuilder result = new StringBuilder();
        String[] words = splitWords(str);
        boolean firstIteration = true;

        for (String word : words) {
            if(!word.isEmpty()) {
                result.append(firstIteration ? word.toLowerCase() : capitalize(word));
                firstIteration = false;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        //theLastOfMohicans
        var result1 = camelCase("_The_last_$of-Mohicans!");
        System.out.println(result1);

        //weWillRockYou
        var result2 = camelCase("We#will_Rock_You");
        System.out.println(result2);

    }

    // ver 2: org.apache.commons - String camelCase = CaseUtils.toCamelCase(text, false, delimiter);
    // ver 3: com.google.guava -
                                // text.toUpperCase().replaceAll(' ', "_");
                                // String camelCase = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, text);
}

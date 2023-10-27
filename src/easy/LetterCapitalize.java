package easy;
/**
  Have the function LetterCapitalize(str) take the str parameter
  being passed and capitalize the first letter of each word.
  Words will be separated by only one space.
 */

public class LetterCapitalize {
    private static String letterCapitalize(String str) {
        String[] splitWords = splitWords(str);

        for (int i = 0; i < splitWords.length; i++) {
            splitWords[i] = capitalize(splitWords[i]);
        }

        return String.join(" ", splitWords);
    }

    private static String[] splitWords(String str) {
        return str.split("[\\W_]+");

       /* ver 2 Without empty words
                return str
                .replaceAll("[^a-zA-Z]+", " ")
                .trim()
                .split("\\s+");*/
    }

    private static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static void main(String[] args) {
        var result1 = letterCapitalize("Go to the light");
        System.out.println(result1);

        var result2 = letterCapitalize("Find the truth and the truth will set you free");
        System.out.println(result2);
    }



}

package easy;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
  Have the function ExOh(str) take the str parameter being passed
  and return the string true if there is an equal number of x's and o's,
  otherwise return the string false. Only these two letters
  will be entered in the string, no punctuation or numbers.
  For example: if str is "xooxxxxooxo" then the output
  should return false because there are 6 x's and 5 o's.
 */

public class ExOh {


    public static String exOh(String str) {


        if(str.length() % 2 != 0) return "false";

        int strLength = str.length();
        int halfOfStrLength = str.length()/2;

        char[] chars = str.toCharArray();
        Arrays.sort(chars);

         /* more expensive variant of sorting
          String sorted = str.chars()
            .sorted()
            .mapToObj(Integer::toString)
            .collect(Collectors.joining(", "));*/

        StringBuilder stringBuilder = new StringBuilder(String.valueOf(chars));

        String firstPart = stringBuilder.toString().substring(0, halfOfStrLength);
        String secPart = stringBuilder.reverse().toString().substring(strLength-halfOfStrLength);

        return firstPart.equals(secPart) ? "true" : "false";
    }

    public static void main(String[] args) {
        var result1 = exOh("xxxooo");
        System.out.println(result1);

        var result2 = exOh("xxxoo");
        System.out.println(result2);
    }

}
//ver 2:

 /* public static String exOh(String str) {
        long countX = str.chars().filter(ch -> ch == 'x').count();
        long countO = str.chars().filter(ch -> ch == 'o').count();

        return (countX == countO) ? "true" : "false";
    }*/

//ver 3:

/*
    public static String exOh(String str) {
        int countX = str.length() - str.replaceAll("x", "").length();
        int countO = str.length() - str.replaceAll("o", "").length();

        return (countX == countO) ? "true" : "false";
    }

* */

//ver 4:
/*
public static String exOh(String str) {
    int countX = 0;
    int countO = 0;

    for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        if (c == 'x') {
            countX++;
        } else if (c == 'o') {
            countO++;
        }
    }

    return (countX == countO) ? "true" : "false";
}
* */

//ver 5:
/*
 private static String exOh(String str) {
        int balance = 0;
        String[] letters = str.toLowerCase().split("");

        for (String letter : letters) {
            switch (letter) {
                case "x":
                    balance++;
                    break;
                case "o":
                    balance--;
                    break;
                default:
                    break;
            }
        }

        return balance == 0 ? "true" : "false";
    }
* */
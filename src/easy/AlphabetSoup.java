package easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
  Have the function AlphabetSoup(str) take the str string parameter being passed
  and return the string with the letters in alphabetical order (i.e. hello becomes ehllo).
  Assume numbers and punctuation symbols will not be included in the string.
 */

public class AlphabetSoup {

    private static String alphabetSoup(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);

        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        var result1 = alphabetSoup("morningsun"); //gimnnnorsu
        System.out.println(result1);

        var result2 = alphabetSoup("lifestyle"); //eefillsty
        System.out.println(result2);
    }

    /* private static String alphabetSoup(String str) {
         //sorted by its ASCII codes, so capital letters goes first abC -> Cab
         //mapping needs if we want to use different Comparator realizations
        return str.toLowerCase()
                .chars()
                .mapToObj(c -> (char) c)
                .sorted(Comparator.naturalOrder())
                .collect(Collector.of(
                        StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append,
                        StringBuilder::toString));
    }*/
}

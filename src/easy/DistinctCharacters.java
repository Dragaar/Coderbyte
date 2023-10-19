package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
  Have the function DistinctCharacters(str) take the str parameter being passed
  and determine if it contains at least 10 distinct characters,
  if so, then your program should return the string true,
  otherwise it should return the string false.
  ---
  For example: if str is "abc123kkmmmm?" then your program should return the string false
  because this string contains only 9 distinct characters:
  a, b, c, 1, 2, 3, k, m. ? adds up to 9.
 */



public class DistinctCharacters {
    private static String distinctCharacters(String str) {
        HashSet<Integer> uniqueChars = new HashSet<>();

        str.chars().forEach(
                uniqueChars::add
        );

        return uniqueChars.size() >= 10 ? "true" : "false";
    }

    public static void main(String[] args) {
        //false
        var result1 = distinctCharacters("abc123kkmmmm?"); //9
        System.out.println(result1);

        //true
        var result2 = distinctCharacters("qwertyggcv1"); //10
        System.out.println(result2);
    }
}

//ver 2:
/*
private static String distinctCharacters(String str) {
    Set<Character> table = new HashSet<>();
    for (int i = 0; i < str.length(); i++) {
      table.add(str.charAt(i));
    }
    return table.size() >= 10 ? "true" : "false";
  }

* */

package easy;
/**
 Have the function ABCheck(str) take the str parameter being passed
 and return the string true if the characters a and b are separated by exactly 3 places
 anywhere in the string at least once (i.e. "lane borrowed" would result in true
 because there is exactly three characters between a and b). Otherwise, return the string false.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ABCheck {

    public static String abCheck(String str) {
        Matcher m = Pattern.compile("a...b|b...a").matcher(str);
        return m.find() ? "true" : "false";
    }
    public static void main (String[] args) {
        // keep this function call here
        var result1 = abCheck("lane borrowed");
        System.out.println(result1); //true
        var result2 = abCheck("armagedobnn");
        System.out.println(result2); //false

    }
}

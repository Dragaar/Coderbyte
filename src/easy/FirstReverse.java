package easy;
/**
  Have the function FirstReverse(str) take the str parameter
  being passed and return the string in reversed order.
  For example: if the input string is "Hello World and Coders"
  then your program should return the string sredoC dna dlroW olleH.
 */

public class FirstReverse {
    private static String firstReverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {
        //sredoC dna dlroW olleH
        var result1 = firstReverse("Hello World and Coders");
        System.out.println(result1);

        //yddub ecnaD steL
        var result2 = firstReverse("Lets Dance buddy");
        System.out.println(result2);
    }

}

package easy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
  Have the function AdditivePersistence(num) take the num parameter being passed
  which will always be a positive integer
  and return its additive persistence which is the number of times
  you must add the digits in num until you reach a single digit.
  ---
  For example: if num is 2718 then your program
  should return 2 because 2 + 7 + 1 + 8 = 18
  and 1 + 8 = 9, and you stop at 9.
 */
/*
 скільки разів треба додавати число щоб досягнути одної цифри
 приклад -
 9 не потрібно додавати, 0 разів
 17 - перша операція (1+7), результат одна операція
 19 - перша операція (1+9), друга (1+0), результат дві операції
 */
public class AdditivePersistence {

    private static int additivePersistence(int num) {
        if(num <= 9) return 0;

        int count = 1;
        int addedDigits = addAllDigits(num);
        while(addedDigits > 9){
            addedDigits = addAllDigits(addedDigits);
            count++;
        }
        return count;
    }

    private static int addAllDigits(int num){
        Matcher matcher = Pattern.compile("\\d")
                .matcher(String.valueOf(num));

        int res = 0;
        while(matcher.find()){
            res += Integer.parseInt(matcher.group());
        }
        return res;
    }


    public static void main(String[] args) {

        var result0 = additivePersistence(9); //0
        System.out.println("0:\n" + "[9]: " + result0);

        var result1 = additivePersistence(17); //1
        System.out.println("1:\n" + "[17]: " + result1);

        var result2 = additivePersistence(19); //2
        var result3 = additivePersistence(167); //2
        System.out.println("2:\n" + "[19, 167]: " + result2 + ", " + result3);

        var result4 = additivePersistence(199); //3
        var result5 = additivePersistence(456789); //3
        System.out.println("3:\n" + "[199, 456789]: " + result4 + ", " + result5);
    }

    /* ver 1:
    private static int additivePersistence(int num) {
        int count = 0;
        int added = num;

        while (added > 9) {
            int sum = 0;

            String numStr = Integer.toString(added);

            for (char digit : numStr.toCharArray())
                sum += Character.getNumericValue(digit);

            added = sum;
            count++;
        }

        return count;
    }*/

    /* ver 2:
    private static int additivePersistence(int num) {
        int times = 0;
        int added = num;
        while (added > 9) {
          int sum = 0;
          String[] intArr = Integer.toString(added).split("");
          for (String i : intArr) {
            sum += Integer.parseInt(i);
          }
          added = sum;
          times++;
        }
        return times;
      }

    * */

}


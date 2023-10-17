package easy;

import java.util.Arrays;

/**
  Have the function DashInsert(str) insert dashes ('-')
  between each two odd numbers in str. For example:
  if str is 454793 the output should be 4547-9-3.
  Don't count zero as an odd number.
 */


public class DashInsert {
    private static String dashInsert(String str) {

        StringBuilder stringBuilder = new StringBuilder();
        boolean wasUnpair = false;

        for(char c : str.toCharArray()){
            if((int) c % 2 != 0){
                if(wasUnpair) stringBuilder.append("-");
                stringBuilder.append(c);
                wasUnpair = true;
            } else {
                stringBuilder.append(c);
                wasUnpair = false;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        //4547-9-3
        var result1 = dashInsert("454793");
        System.out.println(result1);

        //43-764
        var result2 = dashInsert("43764");
        System.out.println(result2);

        //45026
        var result3 = dashInsert("45026");
        System.out.println(result3);
    }


    /* ver 2
      private static String dashInsert(String str) {
        StringBuilder result = new StringBuilder();
        char[] chars = str.toCharArray();

        for (int i = 1; i < chars.length + 1; i++) {
            int c1 = Character.getNumericValue(chars[i - 1]);
            int c2 = i < chars.length ? Character.getNumericValue(chars[i]) : 0;

            result.append(c1);
            if (c1 % 2 != 0 && c2 % 2 != 0) {
                result.append("-");
            }
        }
        return result.toString();
    }*/

}

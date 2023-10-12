package easy;

import java.util.Arrays;

/**
  Have the function BitwiseOne(strArr) take the array of strings stored in strArr,
  which will only contain two strings of equal length that represent binary numbers,
  and return a final binary string that performed the bitwise OR operation
  on both strings.
  ---
  A bitwise OR operation places a 0 in the new string
  where there are zeroes in both binary strings,
  otherwise it places a 1 in that spot.
  ---
  For example: if strArr is ["1001", "0100"] then your program
  should return the string "1101"
 */

public class BitwiseOne {

    private static String bitwiseOne(String[] strArr) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] firstArr = strArr[0].toCharArray();
        char[] secArr = strArr[1].toCharArray();

        for(int i = 0; i < firstArr.length; i++){
            if(firstArr[i] == '0' && secArr[i] == '0')
                stringBuilder.append("0");
            else stringBuilder.append("1");

        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        //101110
        var result1 = bitwiseOne(new String[]{"001110", "100000"});
        System.out.println(result1);

        //110101
        var result2 = bitwiseOne(new String[]{"100101", "110100"});
        System.out.println(result2);
    }

   /* ver 2:
      private static String bitwiseOne(String[] strArr) {
        String s1 = strArr[0];
        String s2 = strArr[1];
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s1.length(); i++) {
            int logicOr = Character.getNumericValue(s1.charAt(i)) | Character.getNumericValue(s2.charAt(i));
            result.append(logicOr);
        }

        return result.toString();
    }*/


}

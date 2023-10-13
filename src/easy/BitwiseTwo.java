package easy;
/**
  Have the function BitwiseTwo(strArr) take the array of strings stored in strArr,
  which will only contain two strings of equal length that represent binary numbers,
  and return a final binary string that performed the bitwise AND operation on both strings.
  ---
  A bitwise AND operation places a 1 in the new string where
  there is a 1 in both locations in the binary strings,
  otherwise it places a 0 in that spot. For example:
  if strArr is ["10111", "01101"] then your program should return the string "00101"
 */

public class BitwiseTwo {

    private static String bitwiseTwo(String[] strArr) {

        StringBuilder stringBuilder = new StringBuilder();
        char[] firstArr = strArr[0].toCharArray();
        char[] secArr = strArr[1].toCharArray();

        for(int i = 0; i < firstArr.length; i++){
            if(firstArr[i] == '1' && secArr[i] == '1')
                stringBuilder.append("1");
            else stringBuilder.append("0");

        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        //00101
        var result1 = bitwiseTwo(new String[]{"10111", "01101"});
        System.out.println(result1);

        //01001
        var result2 = bitwiseTwo(new String[]{"01001", "11011"});
        System.out.println(result2);
    }


    /* ver 2:
    private static String bitwiseTwo(String[] strArr) {

        String s1 = strArr[0];
        String s2 = strArr[1];
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s1.length(); i++) {
            int logicAnd = Character.getNumericValue(s1.charAt(i)) & Character.getNumericValue(s2.charAt(i));
            result.append(logicAnd);
        }

        return result.toString();
    }*/
}

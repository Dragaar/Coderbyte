package easy;
/**
  Have the function BinaryReversal(str) take the str parameter being passed,
  which will be a positive integer, take its binary representation
  (padded to the nearest N * 8 bits), reverse that string of bits,
  and then finally return the new reversed string in decimal form.
  ---
  For example: if str is "47" then the binary version of this integer is 101111,
  but we pad it to be 00101111. Your program should reverse this binary string
  which then becomes: 11110100 and then finally return
  the decimal version of this string, which is 244.
 */

public class BinaryReversal {

    private static int binaryReversal(String str) {

        String binary = Integer.toBinaryString(Integer.parseInt(str));
        String binaryX8 = String.format("%8s", binary).replaceAll(" ", "0");

        return Integer.parseInt(
                             new StringBuilder(binaryX8).reverse().toString()
                             , 2);

    }

    public static void main(String[] args) {
        //160
        var result1 = binaryReversal("5");
        System.out.println(result1);

        //244
        var result2 = binaryReversal("47");
        System.out.println(result2);

        //1
        var result3 = binaryReversal("128");
        System.out.println(result3);

    }

}

//ver 2:
/*
     private static String padLeft(String str, int len) {
        return String.format("%" + len + "s", str).replace(" ", "0");
      }

    private static int binaryReversal(String str) {
        String binStr = Integer.toBinaryString(Integer.parseInt(str));
        int add = binStr.length() % 8 == 0 ? 0 : 1;
        int pad = add + binStr.length() / 8;
        String padStr = padLeft(binStr, pad * 8);
        StringBuilder result = new StringBuilder();
        for (int i = padStr.length() - 1; i >= 0; i--) {
            result.append(Character.getNumericValue(padStr.charAt(i)));
        }
        return Integer.parseInt(result.toString(), 2);
    }

* */

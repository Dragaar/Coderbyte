package easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
  Have the function LargestPair(num) take the num parameter being passed
  and determine the largest double-digit number within the whole number.
  ---
  For example: if num is 4759472 then your program should return 94 because
  that is the largest double-digit number.
  The input will always contain at least two positive digits.
 */

public class LargestPair {
    private static int largestPair(int num) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        String str = Integer.toString(num);

        //split without repeat
        //String[] parts =str.split("(?<=\\G.{2})");
        //for(String s : parts) {queue.add(Integer.valueOf(s));}

        char[] chars = str.toCharArray();

        for(int i = 0; i < chars.length; i++) {
            if(i+1 < chars.length){
                queue.add(Integer.valueOf(""+chars[i]+chars[i+1]));
            }
        }
        return queue.remove();
    }

    public static void main(String[] args) {
        //94
        int result1 = largestPair(4759472);
        System.out.println(result1);

        //73
        int result2 = largestPair(542733571);
        System.out.println(result2);
    }

   /* ver 2:
   private static int largestPair(int num) {
        String numStr = Integer.toString(num);
        int max = 0;

        for (int i = 0; i < numStr.length() - 1; i++) {
            int i1 = Integer.parseInt(String.valueOf(numStr.charAt(i)));
            int i2 = Integer.parseInt(String.valueOf(numStr.charAt(i + 1)));

            int pair = i1 * 10 + i2;
            if (pair > max) {
                max = pair;
            }
        }

        return max;
    }*/


}

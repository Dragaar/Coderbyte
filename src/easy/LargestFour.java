package easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
  Have the function LargestFour(arr) take the array of integers stored in arr,
  and find the four largest elements and return their sum.
  --
  For example: if arr is [4, 5, -2, 3, 1, 2, 6, 6]
  then the four largest elements in this array are 6, 6, 4, and 5
  and the total sum of these numbers is 21, so your program should return 21.
  --
  If there are less than four numbers in the array your program
  should return the sum of all the numbers in the array.
 */


public class LargestFour {
    public static int largestFour(int[] arr) {

        //Comparator<Integer> compareInts = Integer::compare; - standart
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        Collections.addAll(queue, Arrays.stream(arr).boxed().toArray(Integer[]::new));

        int sum = 0;
        for(int i = 0; i < 4; i++) sum+= queue.remove();

        return sum;
    }

    public static void main(String[] args) {
        //36
        int[] arr1 = new int[]{3, 5, 14, 6, 9, 4, 4, 7};
        int result1 = largestFour(arr1);
        System.out.println(result1);

        //16
        int[] arr2 = new int[]{1, 0, 2, 3, 5, 6};
        int result2 = largestFour(arr2);
        System.out.println(result2);

        //75
        int[] arr3 = new int[]{13, 12, 14, 23, 25, 2, 1, 6};
        int result3 = largestFour(arr3);
        System.out.println(result3);
    }

  /*  ver 2:
    public static int largestFour(int[] arr) {
        int sum = 0;

        if (arr.length <= 4) {
            for (int num : arr) {
                sum += num;
            }
        } else {

            Arrays.sort(arr);

            for (int i = arr.length - 1; i >= arr.length - 4; i--) {
                sum += arr[i];
            }
        }

        return sum;
    }*/


}

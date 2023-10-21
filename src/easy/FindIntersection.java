package easy;
/**
  Have the function FindIntersection(strArr) read the array of strings
  stored in strArr which will contain 2 elements: the first element
  will represent a list of comma-separated numbers sorted in ascending order,
  the second element will represent a second list of comma-separated numbers (also sorted).
  Your goal is to return a comma-separated string containing
  the numbers that occur in elements of strArr in sorted order.
  If there is no intersection, return the string false.
 */

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindIntersection {

    //Time complexity: O(1)
    public static String findIntersection(String[] strArr) {

        // Nuance 1: does not guarantee the maintenance of order
        // Nuance 2: HashSet.toString have a style that differs from the required one

        String[] firstSubString = strArr[0].split(",");
        String[] secSubString = strArr[1].split(",");

        HashSet<String> set = new HashSet<>();

        set.addAll(Arrays.asList(firstSubString));
        set.retainAll(Arrays.asList(secSubString));

        return set.toString();
    }

    public static void main(String[] args) {
        //10,15,16
        var result1 = findIntersection(new String[] {"10,15,16,18,23", "10,15,16,19,25"});
        System.out.println(result1);

        //1,5,15
        var result2 = findIntersection(new String[] {"1,3,5,9,15", "1,2,5,15,19,26"});
        System.out.println(result2);

        //10,17
        var result3 = findIntersection(new String[] {"10,12,13,14,17,18", "10,15,17,19"});
        System.out.println(result3);
    }

     //ver 2:
     // Google Guava -
    /*
    Set<String> intersection = Sets.intersection(
            HashSet<String> set = new HashSet<>(Arrays.asList(firstSubString));
             HashSet<String> set = new HashSet<>(Arrays.asList(secSubString));
        );
    */

    //ver 3:

    /*  public static String findIntersection(String[] strArr) {
        String[] firstSubString = strArr[0].split(",");
        String[] secSubString = strArr[1].split(",");

        return Stream.of(firstSubString)
                .filter(Arrays.asList(secSubString)::contains)
                .distinct()
                .collect(Collectors.joining(","));
    }*/

    //ver 4:
    //Time complexity: O(n)

    /*public static String findIntersection(String[] strArr) {

        String[] firstSubString = strArr[0].split(",");
        String[] secSubString = strArr[1].split(",");

        StringJoiner joiner = new StringJoiner(",");

        for (String f : firstSubString) {
            for (String s : secSubString) {
                if (f.equals(s))
                    joiner.add(f);
            }
        }

        return joiner.toString();
    }*/
}

    //ver 5:
    //Time complexity: O(n * logn)

     /*private static int binarySearch(Integer[] coll, Integer key) {
            int lo = 0;
            int hi = coll.length - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (key < coll[mid]) {
                    hi = mid - 1;
                } else if (key > coll[mid]) {
                    lo = mid + 1;
                } else {
                    return mid;
                }
            }
            return -1;
        }

        private static Integer[] toIntArray(String strArr) {
            String[] numsStr = strArr.trim().split(",");

            return Arrays.stream(numsStr)
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
        }

        private static String findIntersection(String[] arr) {
            Integer[] arr1 = toIntArray(arr[0]);
            Integer[] arr2 = toIntArray(arr[1]);
            StringBuilder builder = new StringBuilder();
            for (int i : arr1.length > arr2.length ? arr2 : arr1) {
                int findIndex = binarySearch(arr1.length > arr2.length ? arr1 : arr2, i);
                if (findIndex > -1) {
                    builder.append(i).append(",");
                }
            }
            String result = builder.toString();
            return result.length() == 0 ? "false" : builder.substring(0, result.length() - 1);
        }

    **/
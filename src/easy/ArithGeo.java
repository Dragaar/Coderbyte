package easy;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

/**
  Have the function ArithGeo(arr) take the array of numbers stored in arr
  and return the string "Arithmetic" if the sequence follows an arithmetic pattern
  or return "Geometric" if it follows a geometric pattern.
  ---
  If the sequence doesn't follow either pattern return -1.
  An arithmetic sequence is one where the difference between
  each of the numbers is consistent, where in a geometric sequence,
  each term after the first is multiplied by some constant or common ratio.
  ---
  Arithmetic example: [2, 4, 6, 8] and Geometric example: [2, 6, 18, 54].
  Negative numbers may be entered as parameters, 0 will not be entered,
  and no array will contain all the same elements.
 */

/*
TODO - Complication: add support for all types of geometric sequences
 */

public class ArithGeo {

    private static String arithGeo(int[] arr) {

        boolean isArithmetic = true, isGeometric = true;

        int arithmeticConst = Math.abs(arr[1] - arr[0]);
        int geometricConst = Math.abs(arr[1] / arr[0]);

        Optional<Integer> previousNumber = Optional.empty();
        for(int number : arr){

            if(previousNumber.isEmpty())
            {
                previousNumber = Optional.of(number);
                continue;
            }

            if ( Math.abs(number - previousNumber.get()) != arithmeticConst )
                isArithmetic = false;
            if ( Math.abs(number / previousNumber.get()) != geometricConst )
                isGeometric = false;

            previousNumber = Optional.of(number);
        }

        if(isArithmetic) return "Arithmetic";
        else if(isGeometric) return "Geometric";
        else return "-1";
    }

    public static void main(String[] args) {
        //arithmetic
        var result1 = arithGeo(new int[] {2, 4, 6, 8});
        System.out.println(result1);

        var result2 = arithGeo(new int[] {-3, -4, -5, -6, -7});
        System.out.println(result2);

        //geometric
        var result3 = arithGeo(new int[] {2, 8, 32, 128});
        System.out.println(result3);

        var result4 = arithGeo(new int[] {3, 9, 27, 81});
        System.out.println(result4);

        var result5 = arithGeo(new int[] {-2, -10, -50, -250, -1250}); //5
        System.out.println(result5);

        // if in condition add dividing geometric sequence
        //var result6 = arithGeo(new int[] {-1250, -250, -50, -10, -2}); //5 div
        //System.out.println(result6);

        //neither
        var result7 = arithGeo(new int[] {1, 12, 55, 73, 98});
        System.out.println(result7);

        var result8 = arithGeo(new int[] {2, 4, 6, 12, 14});
        System.out.println(result8);

    }

    /* ver 2:
    private static String arithGeo(int[] arr) {
        AtomicBoolean isArithmetic = new AtomicBoolean(true);
        AtomicBoolean isGeometric = new AtomicBoolean(true);

        int arithmeticConst = Math.abs(arr[1] - arr[0]);
        int geometricConst = Math.abs(arr[1] / arr[0]);

        Arrays.stream(arr)
                .reduce((a, b) ->
                        {
                        int reduceOp = Math.abs(b-a);
                        int divideOp = Math.abs(b/a);
                        if(reduceOp != arithmeticConst) isArithmetic.set(false);
                        if(divideOp != geometricConst) isGeometric.set(false);

                        return b;
                        });

        if(isArithmetic.get()) return "Arithmetic";
        else if(isGeometric.get()) return "Geometric";
        else return "-1";
    }*/

    /* ver 3:
    private static String arithGeo(int[] arr) {
        int difference = arr[1] - arr[0];
        int ratio = arr[1] / arr[0];

        boolean isArithmetic = true;
        boolean isGeometric = true;

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] != difference) {
                isArithmetic = false;
            }

            if (arr[i + 1] / arr[i] != ratio) {
                isGeometric = false;
            }
        }

        *//*if (isArithmetic) {
            return "Arithmetic";
        } else if (isGeometric) {
            return "Geometric";
        } else {
            return "-1";
        }*//*

        return isArithmetic ? "Arithmetic" : (isGeometric ? "Geometric" : "-1");
    }*/
}


//ver 4:
/*
private static String arithGeo(int[] arr) {

        int arithInterval = arr[1] - arr[0];
        int geoInterval = arr[1] / arr[0];
        int arithCount = 0;
        int geoCount = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] == arithInterval) {
                arithCount++;
            }

            if (arr[i + 1] / arr[i] == geoInterval) {
                geoCount++;
            }
        }

        if (arithCount == arr.length - 1) {
            return "Arithmetic";
        }

        if (geoCount == arr.length - 1) {
            return "Geometric";
        }

        return "-1";
    }

* */
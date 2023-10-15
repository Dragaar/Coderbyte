package easy;
/**
  Have the function CheckNums(num1,num2) take both parameters
  being passed and return the string true if num2 is greater
  than num1, otherwise return the string false.
  If the parameter values are equal to each other, then return the string -1.
 */

public class CheckNums {
    private static String checkNums(int num1, int num2) {
        if (num1 == num2) {
            return "-1";
        }

        return num2 > num1 ? "true" : "false";
    }


    public static void main(String[] args) {
        //true
        var result1 = checkNums(43, 12);
        System.out.println(result1);

        //-1
        var result2 = checkNums(50, 50);
        System.out.println(result2);

        //false
        var result3 = checkNums(21, 62);
        System.out.println(result3);

    }

}

package easy;
/**
  Have the function FirstFactorial(num) take
  the num parameter being passed and return the factorial of it.
  For example: if num = 4, then your program
  should return (4 * 3 * 2 * 1) = 24.
  For the test cases, the range will be between 1 and 18
  and the input will always be an integer.
 */

public class FirstFactorial {
    private static int firstFactorial(int num) {
        int fact = 1;
        for(int i = 1; i <= num; i++)
            fact = fact * i;
        return fact;
    }

    public static void main(String[] args) {
        //24
        var result1 = firstFactorial(4);
        System.out.println(result1);

        //720
        var result2 = firstFactorial(6);
        System.out.println(result2);
    }

    //ver 2:
   /* private static int firstFactorial(int num) {
        if (num == 0) {
            return 1;
        } else {
            return num * firstFactorial(num - 1);
        }
    }*/

}

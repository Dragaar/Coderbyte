package easy;
/**
  Have the function GCF(arr) take the array of numbers stored in arr
  which will always contain only two positive integers,
  and return the greatest common factor of them.
  ---
  For example: if arr is [45, 12] then your program should return 3.
  There will always be two elements in the array,
  and they will be positive integers.
 */


public class Gcf {
    private static int gcf(int[] arr) {
        int gcf = 1;

        int min = Math.min(arr[0], arr[1]);

        for(int i = 1; i <= min; i++){
            if(arr[0] % i == 0 && arr[1] % i == 0){
                gcf = i;
            }
        }
        return gcf;
    }


    public static void main(String[] args) {
        //3
        var result1 = gcf(new int[] {45, 12});
        System.out.println(result1);

        //32
        var result2 = gcf(new int[] {32, 256, 512, 2048});
        System.out.println(result2);

        //46
        var result3 = gcf(new int[] {46, 92});
        System.out.println(result3);
    }

   /* private static int gcf(int[] arr) {
        if (arr[0] == 0 || arr[1] == 0) {
            return arr[0] + arr[1];
        }

        return gcf(new int[] {arr[1], arr[0] % arr[1]});
    }*/

}

package hard;

import java.util.Arrays;
import java.util.Scanner;

public class NimWinnerClass {

    /**
     * Using the JavaScript language, have the function NimWinner(arr) take the
     * array of integers stored in arr which will represent the amount of coins in
     * each pile. For example: [2, 4, 1, 3] means there are 4 piles of coins and
     * there are 2 coins in the first pile, 4 in the second pile, etc. Nim is played
     * by each player removing any number of coins from only one pile, and the
     * winner is the player who picks up the last coin. For example: if arr is [1,
     * 2, 3] then for example player 1 can remove 2 coins from the last pile which
     * results in [1, 2, 1]. Then player 2 can remove 1 coin from the first pile
     * which results in [0, 2, 1], etc. The player that has the last possible move
     * taking the last coin(s) from a pile wins the game. Your program should output
     * either 1 or 2 which represents which player has a guaranteed win with perfect
     * play for the Nim game.
     *
     *
     */
    public static int NimWinner(int[] arr) {
        int x = Arrays.stream(arr)
                .reduce(0, (sum, num) -> sum ^ num);
        return x > 0 ? 1 : 2;
    }

    /* ver 2:
    public static int NimWinner(int[] arr) {

        int mResult = 0, x = 0;

        for (int  i = 0; i < arr.length; i++) {
            x ^= arr[i];
            mResult = x > 0 ? 1 : 2;
        }
        return mResult;
    }*/


    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);

        //System.out.print(NimWinner(s.nextLine()));
        System.out.println(NimWinner(new int[]{1, 2, 3}));
        // out - 2
        System.out.println(NimWinner(new int[]{1, 1, 1, 4, 5, 4}));
        // out - 1
        System.out.println(NimWinner(new int[]{1, 1, 1, 1}));
        // out - 2
        System.out.println(NimWinner(new int[]{1, 1, 1}));
        // out - 1

    }
}

package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;

public class OptimalAssignmentsClass {

    /**
     * Using the JavaScript language, have the function optimalAssignments(strArr)
     * read strArr which will represent an NxN matrix and it will be in the
     * following format: ["(n,n,n...)","(...)",...] where the n's represent
     * integers. This matrix represents a machine at row i performing task at column
     * j. The cost for this is matrix[i][j]. Your program should determine what
     * machine should perform what task so as to minimize the whole cost and it
     * should return the pairings of machines to tasks in the following format:
     * (i-j)(...)... Only one machine can perform one task. For example: if strArr
     * is ["(5,4,2)","(12,4,3)","(3,4,13)"] then your program should return
     * (1-3)(2-2)(3-1) because assigning the machines to these tasks gives the least
     * cost. The matrix will range from 2x2 to 6x6, there will be no negative costs
     * in the matrix, and there will always be a unique answer.
     *
     */

    //На кожен рядок і може бути тільки одна машина. Машина виконує завдання в стовбцях j.
    //Вивести номер машини та номер найбільш оптимального для неї стовпця

    //Calculating result by using permutation matrix
    public static List<Integer[]> permutations;
      public static String OptimalAssignments(String[] strArr) {

        permutations = new ArrayList<>();

        Integer minimalCost = Integer.MAX_VALUE;

        // code goes here
        Integer[][] matrix = create2DArray(strArr, strArr.length, strArr.length);

        Integer[] minPermutationsArr = new Integer[matrix.length];

        List<Integer> list =
                IntStream.range(0, matrix.length)
                        .boxed()
                        .collect(Collectors.toList());
                //java 16+ .boxed().toList()

        permute(list,0);

        // повний список можливих матриць перестановок
        // permutations.forEach(l -> {for(Integer n : l) {System.out.print(n);} System.out.println();} );

        for (Integer[] permutation : permutations) {
          int taskCost =
                  IntStream.range(0, permutation.length)
                  .reduce(0, (int cost, int i)->
                                  cost + matrix[i][permutation[i]]);
          if (taskCost < minimalCost) {
              minimalCost = taskCost;
              minPermutationsArr = permutation;

              //котрі саме матриці підходять, і котра з них буде в якості фінального результату
              //до кінцевих значень матриці слід добавити одиницю 210 -> 321
                  /*System.out.print("найменше знайдено в перестановці -> ");
                  for(Integer n : permutation) {System.out.print(n);}
                  System.out.println();*/
          }
        }

      StringBuilder stringBuilder = new StringBuilder();
      Integer[] finalMinPermutationsArr = minPermutationsArr;

      IntStream.range(0, minPermutationsArr.length)
              .forEach(i->
                      stringBuilder.append("(" + (i + 1) + "-" + (finalMinPermutationsArr[i]+1)+")")
                      );
        return stringBuilder.toString();
    }

    private static Integer[][] create2DArray(String[] array, int rows, int collumns)
    {   return IntStream.range(0, rows)
                .mapToObj(i ->
                            convertStringRowsToIntegerArray(array, collumns, i)
                          )
                .toArray(Integer[][]::new);
    }
        private static Integer[] convertStringRowsToIntegerArray(String[] array, int collumns, int rowIndex) {
              return IntStream.range(0, collumns)
                      .mapToObj((int j) -> splitMatrixRowFromString(array[rowIndex])[j])
                      .mapToInt(Integer::parseInt)
                      .boxed()
                      .toArray(Integer[]::new);
        }
        private static String[] splitMatrixRowFromString(String row) {
            return  row
                    .substring(1,row.length()-1)
                    .split(",");
        }

    static void permute(List<Integer> list, int k) {
        for (int i = k; i < list.size(); i++) {
            Collections.swap(list,i,k);
            permute(list,k + 1);
            Collections.swap(list,k,i);
        }

        if (k == list.size() -1) {
            Integer[] arr = list.toArray(new Integer[list.size()]);
            permutations.add(arr);
        }
    }

    public static void main (String[] args) {
        // keep this function call here
        //Scanner s = new Scanner(System.in);

        //повертає в форматі (рядок і - стовпчик j) (i-j)(i-j)

        //System.out.print(OptimalAssignments(s.nextLine()));
        System.out.println(OptimalAssignments(new String[]{"(5,4,2)", "(12,4,3)", "(3,4,13)"}));
        //out (1-3)(2-2)(3-1)
        System.out.println(OptimalAssignments(new String[]{"(1,2,1)", "(4,1,5)", "(5,2,1)"}));
        //out (1-1)(2-2)(3-3)
        System.out.println(OptimalAssignments(new String[]{"(5,4,2)", "(12,4,3)", "(3,4,13)"}));
        //out (1-3)(2-2)(3-1)
        System.out.println(OptimalAssignments(new String[]{ "(13,4,7,6)",
                                                            "(1,11,5,4)",
                                                            "(6,7,2,8)",
                                                            "(1,3,5,9)"}));
        //out (1-2)(2-4)(3-3)(4-1)

        System.out.println(OptimalAssignments(new String[]{
                "(90,75,75,80,82)",
                "(35,85,20,50,41)",
                "(40,2,24,1,67)",
                "(4,70,2,11,23)",
                "(23,25,56,44,21)"
        }));
        //out (1-2)(2-3)(3-4)(4-1)(5-5)


    }

    /* ver 2:
    public static List<Integer[]> permutations = new ArrayList<>();
    public static Integer[] minPermutationsArr = new Integer[0];
    public static Integer minCost = Integer.MAX_VALUE;

    public static String OptimalAssignments(String[] strArr) {
        //reinitializing cause of static
        permutations = new ArrayList<>();
        minCost = Integer.MAX_VALUE;

        // code goes here
        Integer[][] matrix = new Integer[strArr.length][strArr.length];

        minPermutationsArr = new Integer[matrix.length];

        for (int i = 0; i < strArr.length; i++) {
            String[] splitted = strArr[i]
                    .substring(1,strArr[i].length()-1)
                    .split(",");

            for (int j = 0; j < splitted.length; j++) {
                matrix[i][j] = Integer.parseInt(splitted[j]);
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            list.add(i);
        }

        permute(list,0);

        for (Integer[] permutation : permutations) {
            int cost = 0;

            for (int i = 0; i < permutation.length; i++) {
                cost += matrix[i][permutation[i]];
            }

            if (cost < minCost) {
                minCost = cost;
                minPermutationsArr = permutation;
            }
        }

        String result = "";

        for (int i = 0; i < minPermutationsArr.length; i++) {
            result += "(" + (i + 1) + "-" + (minPermutationsArr[i]+1)+")";
        }
        return result;
    }

    static void permute(List<Integer> list, int k) {
        for (int i = k; i < list.size(); i++) {
            Collections.swap(list,i,k);
            permute(list,k + 1);
            Collections.swap(list,k,i);
        }

        if (k == list.size() -1) {
            Integer[] arr = list.toArray(new Integer[list.size()]);
            permutations.add(arr);
        }
    }*/
}

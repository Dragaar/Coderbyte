package hard;

import java.util.function.BinaryOperator;

public class NumberEncodingClass {

    /**
    Using the JavaScript language, have the function NumberEncoding(str)
    take the str parameter and encode the message according to the following rule:
    encode every letter into its corresponding numbered position in the alphabet.
    Symbols and spaces will also be used in the input. For example: if str is "af5c a#!"
    then your program should return 1653 1#!.
     */


    /* 1 опускаємо до нижнього регістру
     * 2 розбиваємо String на char-си (але вони йдуть як int)
     * 3 мапимо int до нормальних char-сів
     * 4 проводимо операцію над кожним char-сом.
     *      result - проміжний результат всіх операцій
     *      charr - кожен наступній char-с в потоці
     *   обєднюємо всі проміжні результати як String::concat
     */

    public static String StringChallenge(String str) {
        // code goes here
        return str.toLowerCase()
                .chars()
                .mapToObj(c -> (char) c)
                .reduce("", (result, charr) -> {
                        if(Character.isLetter(charr)){
                            return result+=charr-97+1;
                        } else {
                            return result+=charr;
                        }
                    },
                String::concat
                //або (x, y) -> x+y
                );
    }

    /* ver 2:
    public static String StringChallenge(String str) {
        // code goes here
        String result="";
        str.toLowerCase();
        for(int i=0;i<str.length();i++){
            if(Character.isLetter(str.charAt(i))){
                result+=str.charAt(i)-97+1;
            }
            else{
                result+=str.charAt(i);
            }
        }
        return result;
    }*/

    public static void main (String[] args) {
        // keep this function call here
        //Scanner s = new Scanner(System.in);
        //System.out.print(StringChallenge(s.nextLine()));

        System.out.println(StringChallenge("af5c a#!"));
        //out - 1653 1#!
    }
}

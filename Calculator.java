import java.util.Scanner;

/*
 * Excercise developed by Carol Zander and Rob Nash with edits by Ryan Decker
 *
 * Complete the calculate() function below to build a simple integer
 * calculator that evaluates a compound expression from left to right,
 * regardless of operator precedence
 *
 * Example: " 1 * -3 + 6 / 3"
 * Execution: calculate 1 * -3 first, then -3 + 6 next,
 * then 3 / 3 last to obtain the value 1
 *
 * @Student Michael Kim
 */
public class Calculator {
    public static void main(String[] args) {
        String input = "4 + 4";
        //String input = "4 + 4 / 2";
        //String input = "1 * -3";
//String input = "1 * -3 + 6 / 3";
//String input = "5";
//String input = "-5";
        int answer = calculate(input);
        System.out.println("Answer is " + answer);
    }

    // preconditions: all binary operations are separated via a space
// postconditions: returns the total of the processed string
    public static int calculate(String input) {
        // parse input string and determine if each character is an operator or number
        char operator = '+';
        int total = 0;

        // .split() the input string using " " as the delimiter
        String[] toParse = input.split(" ");
        // not sure what this regex is.. intellej put that there

        for (int x = 0; x < toParse.length; x++) {
            // if the examined input element is only 1 char long and contains "/*-+" it is an operator
            if (toParse[x].length() == 1 && "+-/*".contains(toParse[x])) {
                operator = toParse[x].charAt(0);

                // if not parse for int
            } else {
                // given that the input string is always number followed by operator
                int number = Integer.parseInt(toParse[x]);
                switch (operator) {
                    case '+':
                        total = total + number;
                        break;
                    case '-':
                        total = total - number;
                        break;
                    case '*':
                        total = total * number;
                        break;
                    case '/':
                        // diving by 0 will make problems. but so will all sorts of other inputs so...
                        total /= number;
                        break;
                    default:
                        System.out.println("the input string contains a valid input");
                }
            }
        }
        // I honestly got a lot of help on this one. Very challenging yet fun to build.
        return total;
    }


}

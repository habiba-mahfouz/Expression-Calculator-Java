package calculator;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner hm = new Scanner(System.in);
        Boolean running = true; // still run until running = false
        while (running) {
            System.out.print(" Enter the infix expression: ");
            String infix_s = hm.nextLine(); // take expression
            String infix_NOs = infix_s.replaceAll("\\s+", "");  // remove any whitespaces
            System.out.println(".................... Calculator ....................");
            System.out.println(" 1. Convert infix expression to postfix expression ");
            System.out.println(" 2. Evaluate the postfix expression ");
            System.out.println(" 3. both 1 and 2 ");
            System.out.println(" 4. Exit ");
            System.out.print(" Please enter your choice: "); // enter the operation you want
            int choice = Integer.parseInt(hm.nextLine()); // to start from new line 
            switch (choice) {
                case 1:
                    // from infix to postfix
                    System.out.println("Postfix expression: " + postfix(infix_NOs));
                    break;
                case 2:
                    // evaluate postfix
                    System.out.println("Result: " + result(infix_NOs));
                    break;
                case 3:
                    //both
                    System.out.println("Postfix expression: " + postfix(infix_NOs));
                    System.out.println("Result: " + result(infix_NOs));
                    break;
                case 4:
                    // exit the calc
                    System.out.println(" Thank you for using our calculator :) ");
                    running = false;
                    break;
                default:
                    System.out.println("Unavilable choice ! Try again later !");
                    running = false;
                    break;
            }
            System.out.println("....................................................");
        }
    }

    public static String postfix(String infix) {
        return Stack_SLL_Calculator.toPostfix(infix);
    }

    public static double result(String infix) {
        String postfix = postfix(infix);
        return Stack_SLL_Calculator.evaluatePostfix(postfix);
    }

}

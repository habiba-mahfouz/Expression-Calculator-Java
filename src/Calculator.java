package calculator;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            try {
                System.out.println("\n.................... Calculator ....................");
                System.out.print(" Enter the infix expression: ");
                String infix_s = scanner.nextLine();
                if (infix_s.trim().isEmpty()) {
                    System.out.println(" Please enter a valid expression.");
                    continue;
                }
                
                String infix_NOs = infix_s.replaceAll("\\s+", "");  // remove any whitespaces

                System.out.println(" 1. Convert infix expression to postfix expression ");
                System.out.println(" 2. Evaluate the postfix expression ");
                System.out.println(" 3. Both 1 and 2 ");
                System.out.println(" 4. Exit ");
                System.out.print(" Please enter your choice: ");
                
                String choiceStr = scanner.nextLine();
                int choice = Integer.parseInt(choiceStr);

                switch (choice) {
                    case 1:
                        System.out.println(" Postfix expression: " + postfix(infix_NOs));
                        break;
                    case 2:
                        System.out.println(" Result: " + result(infix_NOs));
                        break;
                    case 3:
                        String pf = postfix(infix_NOs);
                        System.out.println(" Postfix expression: " + pf);
                        System.out.println(" Result: " + Stack_SLL_Calculator.evaluatePostfix(pf));
                        break;
                    case 4:
                        System.out.println(" Thank you for using our calculator :) ");
                        running = false;
                        break;
                    default:
                        System.out.println(" Unavailable choice! Try again.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println(" Error: Please enter a valid number for choice.");
            } catch (ArithmeticException e) {
                System.out.println(" Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println(" Error: Invalid Expression or Processing error. (" + e.getMessage() + ")");
            }
            System.out.println("....................................................");
        }
    }

    public static String postfix(String infix) {
        return Stack_SLL_Calculator.toPostfix(infix);
    }

    public static double result(String infix) {
        String pf = postfix(infix);
        return Stack_SLL_Calculator.evaluatePostfix(pf);
    }

}

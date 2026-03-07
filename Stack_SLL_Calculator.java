
package calculator;


public class Stack_SLL_Calculator {

    static int precedence(char c) {
        if (c == '+' || c == '-') return 1;
        if (c == '*' || c == '/') return 2;
        if (c == '^') return 3;
        return 0;
    }

    public static String toPostfix(String infix) {
        StringBuilder result = new StringBuilder();
        Stack_SLL stack = new Stack_SLL();
        int i = 0;

        while (i < infix.length()) {
            char c = infix.charAt(i);

            if (Character.isDigit(c) || c == '.') {
                StringBuilder number = new StringBuilder();
                while (i < infix.length() &&
                       (Character.isDigit(infix.charAt(i)) || infix.charAt(i) == '.')) {
                    number.append(infix.charAt(i));
                    i++;
                }
                result.append(number).append(" ");
                continue;
            }

            else if (c == '(') {
                stack.push(c);
            }

            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop()).append(" ");
                }
                stack.pop(); // شيل (
            }

            else if (c == '+' || c == '-' || c == '*' || c == '/'|| c == '^') {
                while (!stack.isEmpty() && stack.peek() != '(' &&
                       precedence(stack.peek()) >= precedence(c)&& c != '^') {
                    result.append(stack.pop()).append(" ");
                }
                stack.push(c);
            }

            i++;
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop()).append(" ");
        }

        return result.toString().trim();
    }

    public static double evaluatePostfix(String postfix) {
        java.util.Stack<Double> stack = new java.util.Stack<>();
        String[] tokens = postfix.split("\\s+");

        for (String token : tokens) {
            if (token.matches("\\d+(\\.\\d+)?")) {
                stack.push(Double.parseDouble(token));
            } else {
                double b = stack.pop();
                double a = stack.pop();
                switch (token.charAt(0)) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': stack.push(a / b); break;
                    case '^': stack.push(Math.pow(a, b)); break;
                }
            }
        }

        return stack.pop();
    }


}
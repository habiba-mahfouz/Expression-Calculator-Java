
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
        Stack_SLL<Character> stack = new Stack_SLL<>();
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
                stack.pop(); // remove '('
            }

            else if (c == '+' || c == '-' || c == '*' || c == '/'|| c == '^') {
                while (!stack.isEmpty() && stack.peek() != '(' &&
                       precedence(stack.peek()) >= precedence(c) && c != '^') {
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
        Stack_SLL<Double> stack = new Stack_SLL<>();
        String[] tokens = postfix.split("\\s+");

        for (String token : tokens) {
            if (token.isEmpty()) continue;
            
            // Check if token is a number (integer or decimal)
            if (token.matches("-?\\d+(\\.\\d+)?")) {
                stack.push(Double.parseDouble(token));
            } else {
                if (stack.isEmpty()) throw new RuntimeException("Invalid Expression");
                double b = stack.pop();
                if (stack.isEmpty()) throw new RuntimeException("Invalid Expression");
                double a = stack.pop();
                
                switch (token.charAt(0)) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': 
                        if (b == 0) throw new ArithmeticException("Division by zero");
                        stack.push(a / b); 
                        break;
                    case '^': stack.push(Math.pow(a, b)); break;
                    default: throw new RuntimeException("Unknown operator: " + token);
                }
            }
        }

        if (stack.isEmpty()) throw new RuntimeException("Empty result");
        double result = stack.pop();
        if (!stack.isEmpty()) throw new RuntimeException("Invalid Expression (excess operands)");
        
        return result;
    }

}
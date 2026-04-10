# Expression Calculator (Java) 🧮

A robust Java-based expression calculator that implements the **Shunting-yard algorithm** to convert infix expressions to postfix (Reverse Polish Notation) and evaluates them. This project demonstrates advanced data structure concepts by using a **custom generic Linked-List-based Stack** implementation.

## 🚀 Features

-   **Complex Expressions**: Supports arithmetic operations including addition (`+`), subtraction (`-`), multiplication (`*`), division (`/`), and exponentiation (`^`).
-   **Operator Precedence**: Correctly handles operator priority and parentheses.
-   **Decimal Support**: Processes floating-point numbers (e.g., `2.5 * 4`).
-   **Custom Data Structures**: Uses a custom-built generic `Stack_SLL<T>` and `Node<T>` instead of built-in Java collections to demonstrate deep understanding of Data Structures.
-   **Error Handling**: Gracefully handles invalid expressions, division by zero, and malformed inputs without crashing.
-   **Interactive CLI**: Simple and clean command-line interface for user interaction.

## 🧠 Algorithms

### 1. Shunting-Yard Algorithm
Used for parsing mathematical expressions specified in infix notation. It produces a postfix notation string (RPN).

### 2. Postfix Evaluation
Uses a stack-based approach to evaluate the RPN string.
-   **Numbers**: Pushed onto the stack.
-   **Operators**: Pop the required operands from the stack, perform the operation, and push the result back.

## 📂 Project Structure

```text
src/calculator/
├── Calculator.java           # Main entry point and CLI logic
├── Stack_SLL_Calculator.java # Core logic for conversion and evaluation
├── Stack_SLL.java            # Custom Generic Stack implementation
└── Node.java                # Generic Node for the Stack
```

## 🛠️ Usage

### Prerequisites
-   Java Development Kit (JDK) 8 or higher.

### Running the Application

1.  **Compile the project**:
    ```bash
    javac src/calculator/*.java
    ```

2.  **Run the main class**:
    ```bash
    java -cp src calculator.Calculator
    ```

### Example Input
```text
Enter the infix expression: (3 + 5) * 2 ^ 3
1. Convert infix expression to postfix expression
2. Evaluate the postfix expression
3. Both 1 and 2
4. Exit
Please enter your choice: 3

Postfix expression: 3 5 + 2 3 ^ *
Result: 64.0
```

## 🤝 Contributing
Feel free to fork this repository and submit pull requests for any improvements or bug fixes!

---
Developed with ❤️ by [Habiba Mahfouz](https://github.com/habiba-mahfouz)

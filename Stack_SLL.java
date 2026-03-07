package calculator;

public class Stack_SLL {

    private Node tos;

    public Stack_SLL() {
        tos = null;
    }

    // is_empty
    public Boolean isEmpty() {
        Boolean is_empty = false;
        if (tos == null) {
            is_empty = true;
        }
        return is_empty;
    }

    // push : input at first node 
    public Boolean push(char data) {
        Boolean is_pushed = false;
        Node n = new Node(data);
        if (n != null) {
            is_pushed = true;
            if (isEmpty()) {
                tos = n;
            } else {
                n.setNext(tos);
                tos = n;
            }
        }
        return is_pushed;
    }

    // pop : delete first node and return its value
    public char pop() {
        char value = '\0' ;
        if (!isEmpty()) {
            value = tos.getData();
            tos = tos.getNext();
        }
        return value;
    }

    // peek : return value of first node only
    public char peek() {
        char value = '\0';
        if (!isEmpty()) {
            value = tos.getData();
        }
        return value;
    }

}





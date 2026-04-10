package calculator;

public class Stack_SLL<T> {

    private Node<T> tos;

    public Stack_SLL() {
        tos = null;
    }

    // is_empty
    public Boolean isEmpty() {
        return tos == null;
    }

    // push : input at first node 
    public Boolean push(T data) {
        Boolean is_pushed = false;
        Node<T> n = new Node<>(data);
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
    public T pop() {
        T value = null;
        if (!isEmpty()) {
            value = tos.getData();
            tos = tos.getNext();
        }
        return value;
    }

    // peek : return value of first node only
    public T peek() {
        T value = null;
        if (!isEmpty()) {
            value = tos.getData();
        }
        return value;
    }

}





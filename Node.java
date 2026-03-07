package calculator;

public class Node {

    private char data;
    private Node next;

    public Node(char data) {
        this.data = data;
        next = null;
    }

    public char getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}

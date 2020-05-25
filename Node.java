public class Node {
    int val;
    Node next;


    // constructor
    public Node(int val, Node node) {
        this.val = val;
        this.next = node;
    }

    public Node(int val) {
        this(val, null);
    }

    public Node() {
        this(0, null);
    }


    public static void main(String[] args){

    }
}

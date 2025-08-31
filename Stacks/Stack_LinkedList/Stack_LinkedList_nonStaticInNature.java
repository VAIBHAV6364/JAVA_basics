public class Stack_LinkedList_nonStaticInNature {
    private int size;   // size is now per stack (not shared)

    // Node is now a normal (non-static) inner class
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head of the stack
    private Node head;

    // Constructor
    Stack_LinkedList_nonStaticInNature() {
        this.head = null;
        this.size = 0;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Push operation (add at top)
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head; // new node points to previous head
        head = newNode;      // head moves to new node
        size++;
    }

    // Pop operation (remove from top)
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        int top = head.data;
        head = head.next;  // move head down
        size--;
        return top;
    }

    // Peek (see top without removing)
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return head.data;
    }

    // Print stack
    public void printStack() {
        if (isEmpty()) {
            System.out.println("|-1| (empty)");
            return;
        }

        Node node = head;
        while (node != null) {
            if (node == head) {
                System.out.println("| " + node.data + " | (TOP)");
            } else {
                System.out.println("| " + node.data + " |");
            }
            node = node.next;
        }
    }

    // Get size
    public int getSize() {
        return size;
    }

    // Main method to test
    public static void main(String[] args) {
        Stack_LinkedList_nonStaticInNature s = new Stack_LinkedList_nonStaticInNature();
        Stack_LinkedList_nonStaticInNature s2 = new Stack_LinkedList_nonStaticInNature();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        s2.push(11);
        s2.push(21);
        s2.push(31);
        s2.push(41);
        s2.push(51);

        System.out.println("Size of Stack: " + s.getSize());
        System.out.println();

        System.out.println("Custom print: ");
        s.printStack();

        System.out.println();
        System.out.println("Default method (pop until empty): ");
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }


        System.out.println("Size of Stack: " + s2.getSize());
        System.out.println();

        System.out.println("Custom print: ");
        s2.printStack();

        System.out.println();
        System.out.println("Default method (pop until empty): ");
        while (!s2.isEmpty()) {
            System.out.println(s2.peek());
            s2.pop();
        }
    }
}

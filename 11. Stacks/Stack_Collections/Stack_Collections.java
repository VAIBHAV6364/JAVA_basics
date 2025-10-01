import java.util.*;

public class Stack_Collections {
    public static void main(String args[]) {
        // Creating a stack of integers
        Stack<Integer> s = new Stack<>();

        // PUSH operation (insert elements into stack)
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);

        System.out.println("Stack after pushes: " + s);

        // PEEK operation (view top element without removing)
        System.out.println("Top element (peek): " + s.peek());

        // POP operation (remove top element)
        System.out.println("Popped element: " + s.pop());
        System.out.println("Stack after pop: " + s);

        // SEARCH operation (position from top, 1-based index)
        System.out.println("Position of 20 (from top): " + s.search(20));
        System.out.println("Position of 100 (not present): " + s.search(100)); // returns -1

        // Checking if empty
        System.out.println("Is stack empty? " + s.isEmpty());

        // Print all elements by popping until empty
        System.out.println("\nPrinting all elements by popping:");
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}

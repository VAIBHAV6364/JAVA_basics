import java.util.*;

public class Stack_ArrayList {
    // Inner Stack class
    class Stack {
        ArrayList<Integer> list = new ArrayList<>();

        // IS Empty
        public boolean isEmpty() {
            return list.size() == 0;
        }

        // PUSH
        public void push(int data) {
            list.add(data);
        }

        // POP
        public int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        // PEEK
        public int peek() {
            if (isEmpty()) {
                return -1;
            }
            return list.get(list.size() - 1);
        }

        // Print stack
        public void printStack() {
            if (isEmpty()) {
                System.out.println("|-1| (empty)");
                return;
            }

            for (int i = list.size() - 1; i >= 0; i--) {
                if (i == list.size() - 1) {
                    System.out.println("| " + list.get(i) + " | (TOP)");
                } else {
                    System.out.println("| " + list.get(i) + " |");
                }
            }
        }

        // Get size
        public int getSize() {
            return list.size();
        }
    }

    // Main method to test
    public static void main(String[] args) {
        Stack_ArrayList outer = new Stack_ArrayList(); // outer class object
        Stack s1 = outer.new Stack();                  // inner Stack object
        Stack s2 = outer.new Stack();

        // stack s1
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(4);
        s1.push(5);

        // stack s2
        s2.push(11);
        s2.push(21);
        s2.push(31);
        s2.push(41);
        s2.push(51);

        // Stack s1
        System.out.println("Size of Stack s1: " + s1.getSize());
        System.out.println("\nCustom print (s1): ");
        s1.printStack();

        System.out.println("\nDefault method (pop until empty s1):");
        while (!s1.isEmpty()) {
            System.out.println(s1.peek());
            s1.pop();
        }

        // Stack s2
        System.out.println("\nSize of Stack s2: " + s2.getSize());
        System.out.println("\nCustom print (s2): ");
        s2.printStack();

        System.out.println("\nDefault method (pop until empty s2):");
        while (!s2.isEmpty()) {
            System.out.println(s2.peek());
            s2.pop();
        }
    }
}

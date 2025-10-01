/*
Here, Node is declared as static inner class.
A static inner class does not keep a reference to the outer class object.
This means it cannot access non-static instance variables of the outer class directly.
In your program, both Node and size are declared static, so they work together.
The Stack implementation here is designed so that there’s only one shared stack across the whole program
(not tied to an instance). That’s why static was used.
 */

public class Stack_LinkedList_staticInNature {
    private static int size;

    Stack_LinkedList_staticInNature(){
        this.size = 0;
    }


    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
            size++;
        }
    }

    static class Stack {
        public static Node head;

        //CHECK IF STACK EMPTY
        public static boolean isEmpty() {
            return head == null;
        }

        //PUSH FUNCTION  --> similar to add at first in LinkedList
        public static void push(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        //POP FUNCTION --> return top by removing it from the stack (similar to delete from first in linked list)
        public static int pop() {
            //if stack is empty return -1 indicating no elements
            if (isEmpty()) {
                return -1;
            }
            size--;
            int top = head.data;
            head = head.next;
            return top;
        }

        //PEEK FUNCTION --> return the top value without removing it from the stack
        public static int peek() {
            if (isEmpty()){
                return -1;
            }

            int top = head.data;
            return top;
        }

        public static void printStack(){
            if(isEmpty()){
                System.out.println("|-1|");
                return;
            }

            Node node = head;
            while(node != null){
                if(node == head){
                    System.out.println("| "+node.data+" | (TOP)");
                }
                else {
                    System.out.println("| " + node.data + " |");
                }
                node = node.next;
            }
        }

        //GET SIZE
        public static int size(){
            return size;
        }
    }


    public static void main(String args[]){
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.pop();
        System.out.println();
        System.out.println("Size of Stack : "+ s.size());
        System.out.println();


        System.out.println("Custom print : ");
        s.printStack();

        System.out.println();
        System.out.println("Default method : ");
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
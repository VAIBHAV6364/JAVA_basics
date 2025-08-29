import java.util.*;
/*
Java’s LinkedList is already a Doubly Linked List (DLL) under the hood.
That means you don’t need a separate class like Collections_DLL.
The same LinkedList class lets you do forward and backward traversal (thanks to the doubly-linked implementation).
 */
public class Collections_DLL {
    public static void main(String args[]) {
        LinkedList<String> dll = new LinkedList<String>();

        // Add at First
        dll.addFirst("a");
        dll.addFirst("is");
        System.out.println(dll);

        dll.addFirst("this");
        // Add at Last
        dll.addLast("Doubly Linked List");
        System.out.println(dll);

        // Size of DLL
        System.out.println("Size : " + dll.size());

        // Forward Traversal
        System.out.print("Forward Traversal : ");
        for(int i = 0; i < dll.size(); i++) {
            System.out.print("|"+ dll.get(i) + "| <--> ");
        }
        System.out.println("null");

        // Backward Traversal
        System.out.print("Backward Traversal : ");
        ListIterator<String> itr = dll.listIterator(dll.size()); // start from end
        while(itr.hasPrevious()) {
            System.out.print(itr.previous() + " <--> ");
        }
        System.out.println("null");

        // Get First
        System.out.println("First element : " + dll.getFirst());

        // Get Last
        System.out.println("Last element : " + dll.getLast());

        // Get any index
        System.out.println("Third element : " + dll.get(2));

        // Delete at first
        dll.removeFirst();
        System.out.println(dll);

        // Delete at last
        dll.removeLast();
        System.out.println(dll);

        // Delete at index
        dll.remove(1);
        System.out.println(dll);
    }
}

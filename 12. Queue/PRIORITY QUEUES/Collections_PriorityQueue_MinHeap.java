import java.util.*;
public class Collections_PriorityQueue_MinHeap {
    public static void main(String[] args) {
        // Default: Min-Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Insert elements (O(log n) each)
        pq.add(10);
        pq.add(5);
        pq.add(20);

        System.out.println("Priority Queue: " + pq);

        // Access head element (O(1))
        System.out.println("Peek (smallest): " + pq.peek());

        // Remove head element (O(log n))
        System.out.println("Poll (removes smallest): " + pq.poll());
        System.out.println("After Poll: " + pq);
    }
}

/*

Complexity :
Insertion (add) → O(log n)
Deletion (poll) → O(log n)
Peek → O(1)

 */
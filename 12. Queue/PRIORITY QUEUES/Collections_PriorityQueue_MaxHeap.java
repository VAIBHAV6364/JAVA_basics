import java.util.*;
public class Collections_PriorityQueue_MaxHeap {
    public static void main(String[] args) {
        // Max-Heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Insert elements (O(log n) each)
        maxHeap.add(10);
        maxHeap.add(5);
        maxHeap.add(20);

        System.out.println("Priority Queue (max heap): " + maxHeap);

        // Access head element (O(1))
        System.out.println("Peek (largest): " + maxHeap.peek());

        // Remove head element (O(log n))
        System.out.println("Poll (removes largest): " + maxHeap.poll());
        System.out.println("After Poll: " + maxHeap);
    }
}

/*

Complexity :
Insertion (add) → O(log n)
Deletion (poll) → O(log n)
Peek → O(1)

 */

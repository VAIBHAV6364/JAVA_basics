/*

Complexity :
Insertion (add) → O(log n)
Deletion (poll) → O(log n)
Peek → O(1)

 */

public class PriorityQueueCustom {
    private int[] heap;     // array to store heap elements
    private int size;       // number of elements in heap
    private int capacity;   // max capacity

    // constructor
    public PriorityQueueCustom(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity + 1];  // 1-indexed heap
        size = 0;
    }

    // Insert element into heap
    public void add(int val) {
        if (size == capacity) {
            System.out.println("Heap is full!");
            return;
        }
        heap[++size] = val;     // place at end
        upHeapify(size);        // fix heap property
    }

    // Remove and return smallest element
    public int poll() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty!");
        }
        int min = heap[1];      // root element
        heap[1] = heap[size--]; // move last element to root
        downHeapify(1);         // fix heap
        return min;
    }

    // Return smallest element without removing
    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty!");
        }
        return heap[1];
    }

    // Maintain heap after insertion
    private void upHeapify(int i) {
        while (i > 1 && heap[i] < heap[i / 2]) {
            swap(i, i / 2);
            i = i / 2;
        }
    }

    // Maintain heap after deletion
    private void downHeapify(int i) {
        int smallest = i;
        int left = 2 * i, right = 2 * i + 1;

        if (left <= size && heap[left] < heap[smallest]) smallest = left;
        if (right <= size && heap[right] < heap[smallest]) smallest = right;

        if (smallest != i) {
            swap(i, smallest);
            downHeapify(smallest);
        }
    }

    // Swap helper
    private void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    // Check if empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Get size
    public int size() {
        return size;
    }

    // Print heap elements
    public void printHeap() {
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    // Main function to test
    public static void main(String[] args) {
        PriorityQueueCustom pq = new PriorityQueueCustom(10);

        pq.add(50);
        pq.add(30);
        pq.add(20);
        pq.add(40);
        pq.add(10);

        System.out.println("Heap elements: ");
        pq.printHeap();

        System.out.println("Peek (smallest): " + pq.peek());

        System.out.println("Polling elements:");
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
    }
}
// Heap Sort Program in Java
// Time Complexity : (n log n)
public class HeapSort {

    // Function to perform heap sort
    public void sort(int arr[]) {
        int n = arr.length;

        // Step 1: Build max heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Step 2: Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root (largest) to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify the reduced heap
            heapify(arr, i, 0);
        }
    }

    // Function to heapify a subtree rooted at index i
    void heapify(int arr[], int n, int i) {
        int largest = i;         // Initialize largest as root
        int left = 2 * i + 1;    // Left child index
        int right = 2 * i + 2;   // Right child index

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // If largest is not root, swap and continue heapifying
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
    }

    // Main method to test the algorithm
    public static void main(String[] args) {
        int arr[] = {2, 8, 5, 3, 9, 1};
        System.out.println("Original array:");
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();

        HeapSort hs = new HeapSort();
        hs.sort(arr);

        System.out.println("\nSorted array (ascending):");
        for (int i : arr)
            System.out.print(i + " ");
    }
}

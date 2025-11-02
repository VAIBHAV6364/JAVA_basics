// Counting Sort Program in Java
// Time Complexity : O(n + k)                 n is number of elements         k is range , eg : 3 - 15 numbers are there then k = 16
class CountingSort {

    // Function to perform counting sort
    void sort(int arr[]) {
        int n = arr.length;

        // Step 1: Find the maximum value in the array
        int max = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > max)
                max = arr[i];

        // Step 2: Create a count array of size (max + 1)
        int count[] = new int[max + 1];

        // Step 3: Count each element's frequency
        for (int i = 0; i < n; i++)
            count[arr[i]]++;

        // Step 4: Change count[i] so that it now contains
        // the actual position of this element in the output array
        for (int i = 1; i <= max; i++)
            count[i] += count[i - 1];

        // Step 5: Build the output array (traverse input from end for stability)
        int output[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        // Step 6: Copy the sorted output array back to the original array
        for (int i = 0; i < n; i++)
            arr[i] = output[i];
    }

    // Main method to test the algorithm
    public static void main(String[] args) {
        int arr[] = {4, 2, 2, 8, 3, 3, 1};

        System.out.println("Original Array:");
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();

        CountingSort cs = new CountingSort();
        cs.sort(arr);

        System.out.println("\nSorted Array:");
        for (int i : arr)
            System.out.print(i + " ");
    }
}

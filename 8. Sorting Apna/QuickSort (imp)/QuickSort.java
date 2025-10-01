import java.util.Scanner;

public class QuickSort {
    public static void quickSort(int arr[], int Low, int High) {
        if (Low < High) {
            int pivotIndex = partition(arr, Low, High);
            quickSort(arr, Low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, High);
        }
    }

    public static int partition(int arr[], int Low, int High) {
        int pivot = arr[High];
        int i = Low - 1;

        for (int j = Low; j < High; j++) {
            if (arr[j] < pivot) {
                i++; // making i++ will ensure to add new space in the what supposed to be a sorted
                     // array for the elements less than pivot

                // swapping
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[High] = temp;
        return i; // pivot's index
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of array elements : ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        System.out.println("Enter the elements of the array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Unsorted array : ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.println("Sorted array through Quick sort : ");

        quickSort(arr, 0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
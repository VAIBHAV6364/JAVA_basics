import java.util.*;

public class SpiralOrder {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int i, j, n = 5, m = 5;
        int arr[][] = new int[n][m];
        System.out.println("Enter the array elements : ");
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("Spiral Order Matrix : ");
        for (i = 0; i < n; i++) {
            if (i == 0 || i % 2 == 0) {
                for (j = 0; j < m; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            } else {
                for (j = m - 1; j >= 0; j--) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
import java.util.Scanner;

public class Transpose {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Use user-defined dimensions for a more flexible program
        int n, m;
        System.out.print("Enter the number of rows (n): ");
        n = sc.nextInt();
        System.out.print("Enter the number of columns (m): ");
        m = sc.nextInt();

        int originalMatrix[][] = new int[n][m];
        System.out.println("Enter the array elements : ");

        // 1. Read the original matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                originalMatrix[i][j] = sc.nextInt();
            }
        }

        // 2. Print the original matrix
        System.out.println("Original Matrix : ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(originalMatrix[i][j] + " ");
            }
            System.out.println();
        }

        // 3. Compute the transpose matrix
        // The transpose matrix has dimensions m x n
        int transposeMatrix[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                transposeMatrix[i][j] = originalMatrix[j][i];
            }
        }

        // 4. Print the transpose matrix
        System.out.println("\nTranspose of the Matrix : ");
        for (int i = 0; i < m; i++) { // Loop through rows of the transpose (which is m)
            for (int j = 0; j < n; j++) { // Loop through columns of the transpose (which is n)
                System.out.print(transposeMatrix[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
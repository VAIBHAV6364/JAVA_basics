//FLOYD's TRIANGLE
public class ConNumHalfPy {
    public static void main(String args[]) {
        int n = 5, k = 0;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                ++k;
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }
}

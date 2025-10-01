public class invertedNumPy {
    public static void main(String args[]) {
        int n = 5;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= 5 - i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}

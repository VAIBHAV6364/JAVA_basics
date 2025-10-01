public class ButterFlyPattern {
    public static void main(String args[]) {
        int n = 10;
        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            for (int j = n - (2 * i); j > 0; j--) {
                System.out.print("  ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        for (int i = 0; i < n / 2; i++) {
            for (int j = (n / 2) - i; j >= 1; j--) {
                System.out.print("* ");
            }

            for (int j = 0; j < 2 * i; j++) {
                System.out.print("  ");
            }

            for (int j = (n / 2) - i; j >= 1; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

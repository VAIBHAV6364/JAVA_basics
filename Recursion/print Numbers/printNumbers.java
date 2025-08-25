public class printNumbers {
    public static void printer(int n) {
        if (n < 0)
            return;

        System.out.println(n);
        printer(n - 1);
    }

    public static void main(String args[]) {
        int n = 10;
        printer(n);
    }
}
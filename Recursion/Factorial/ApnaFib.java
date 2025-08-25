public class ApnaFib {
    public static void main(String args[]) {
        int a = 0, b = 1, n = 10;
        System.out.println("The fibonacci series upto " + n + "is : ");
        System.out.println(a);
        System.out.println(b);
        printFib(a, b, n - 2); // n-2 since we have already printed the first two numbers
    }

    public static void printFib(int a, int b, int n) {
        if (n == 0)
            return;

        int c = a + b;
        System.out.println(c);
        printFib(b, c, n - 1);
    }

}

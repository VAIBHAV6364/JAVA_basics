public class sumNatNums {
    public static void printSum(int i, int n, int sum) {
        if (i > n) {
            System.out.println("Sum of natural numbers upto " + n + " is : " + sum);
            return;
        }

        sum += i;
        printSum(i + 1, n, sum);
        // System.out.println(i);

        // this would print 10 9 8 7 6 5 4 3 2 1..... as it is
        // run after last recursion is
        // returned when it is closing all layers of stack one by one.
        // y 10 also because we are searching till i > n which means it go till 11 then
        // returns
    }

    public static void main(String args[]) {
        int n = 10;
        printSum(1, n, 0);
    }
}
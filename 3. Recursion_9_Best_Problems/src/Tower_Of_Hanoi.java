import java.util.*;
public class Tower_Of_Hanoi {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Disks in the Tower of Hanoi : ");
        int n = sc.nextInt();
        System.out.println("Total number of Moves for "+n+" disks : "+(Math.pow(2,n)-1));
        towerOfHanoi(n, "Source", "Middle-Helper", "Destination");
    }

    public static void towerOfHanoi(int n, String S, String H, String D){
        if(n == 1){
            System.out.println("Move disk "+n+" from "+S+" to "+D);
            return;
        }

        towerOfHanoi(n-1, S, D, H);
        System.out.println("Move disk "+n+" from "+S+" to "+D);
        towerOfHanoi(n-1, H, D, S);
    }
}

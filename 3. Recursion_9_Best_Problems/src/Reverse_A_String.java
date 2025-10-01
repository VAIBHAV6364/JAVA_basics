import java.util.*;
public class Reverse_A_String {
    public static void reverseString(String str, int idx){
        if(idx == 0){
            System.out.print(str.charAt(idx));
            return;
        }

        System.out.print(str.charAt(idx));
        reverseString(str, idx -1);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string to be reversed : ");
        String str = sc.nextLine();
        reverseString(str, str.length()-1);
    }
}

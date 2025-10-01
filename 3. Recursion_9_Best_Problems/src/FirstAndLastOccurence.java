import java.sql.SQLOutput;
import java.util.*;
public class FirstAndLastOccurence {
    public static int first = -1;
    public static int last = -1;
    public static void occurence(String str, int idx, char c){
        if(idx == str.length()){
            System.out.println("THe First occurence of "+c+" : "+first);
            System.out.println("The last occurence of "+last);
            return;
        }

        char currChar = str.charAt(idx);
        if(currChar == c){
            if(first == -1)
                first = idx;
            else
                last = idx;
        }
        occurence(str, idx+1, c);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string : ");
        String str = sc.nextLine();
        System.out.println("Enter the character to check : ");
        char c = sc.next().charAt(0);
        occurence(str, 0, c);
    }
}

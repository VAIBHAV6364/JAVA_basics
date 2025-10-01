import java.util.Scanner;
import java.util.Arrays;
public class AnagramCheck {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first string : ");
        String str1 = sc. nextLine();
        System.out.println("Enter the second string : ");
        String str2 = sc.nextLine();

        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        if(str1.length() != str2.length()){
            System.out.println("Not an Anagram");
        }
        else{
            char[] arr1 = str1.toCharArray();
            char[] arr2 = str2.toCharArray();

            Arrays.sort(arr1);
            Arrays.sort(arr2);

            if(Arrays.equals(arr1, arr2))
                System.out.println("YEs, it is am Anagram!");
            else
                System.out.println("Not an Anagram");
        }
    }
}

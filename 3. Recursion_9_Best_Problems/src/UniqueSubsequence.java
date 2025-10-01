import java.util.HashSet;
public class UniqueSubsequence {
    public static void uniqueSubsequence(String str, int idx, String newString, HashSet<String> set){
        if(idx == str.length()){
            if(set.contains(newString)){
                return;
            }
            else{
                System.out.println(newString);
                set.add(newString);
                return;
            }
        }

        char curChar = str.charAt(idx);

        //charcter wants to be in
        uniqueSubsequence(str, idx+1, newString+curChar, set);

        //character does not want to be in
        uniqueSubsequence(str, idx+1, newString, set);
    }

    public static void main(String args[]){
        String str = "aaaa";
        HashSet<String> set = new HashSet<>();
        System.out.println();
        System.out.println("The set of subsequences are : ");
        uniqueSubsequence(str, 0, "", set);
    }
}

public class Subsequence {
    public static void subsequence(String str, int idx, String newString){
        if(idx == str.length()){
            System.out.println(newString);
            return;
        }

        char curChar = str.charAt(idx);

        //charcter wants to be in
        subsequence(str, idx+1, newString+curChar);

        //character does not want to be in
        subsequence(str, idx+1, newString);
    }

    public static void main(String args[]){
        String str = "abcd";
        System.out.println();
        System.out.println("The set of subsequences are : ");
        subsequence(str, 0, "");
    }
}

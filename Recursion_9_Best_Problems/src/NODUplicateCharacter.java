public class NODUplicateCharacter {
    public static void noDuplicate(String str, int idx, boolean map[], String newString){
        if(idx == str.length()){
            System.out.println("New String without any duplicates : "+ newString);
            return;
        }

        char curChar = str.charAt(idx);
        if(map[curChar - 'a'] == false){
            newString += curChar;
            map[curChar - 'a'] = true;
            noDuplicate(str, idx+1, map, newString);
        }

        else{
            noDuplicate(str, idx+1, map, newString);
        }
    }

    public static void main(String args[]){
        String str = "abbcadcdabzxzkz";
        boolean map[] = new boolean[26];
        System.out.println();
        System.out.println("String with no duplicates : ");
        noDuplicate(str, 0, map, "");
    }
}

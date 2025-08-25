public class MoveAllX {
    public static void moveAllX(String str, int idx, int count, String newString){
        if(idx == str.length()){
            for(int i = 0; i < count; i++){
                newString += 'x';
            }
            System.out.println(newString);
            return;
        }

        char curChar = str.charAt(idx);
        if(curChar == 'x'){
            count++;
            moveAllX(str, idx+1, count, newString);
        }
        else{
            newString += curChar;
            moveAllX(str, idx+1, count, newString);
        }
    }

    public static void main(String args[]){
        String str = "axbcxxd";
        System.out.println();
        System.out.println("New String with all x moved to end of the string : ");
        moveAllX(str, 0, 0, "");
    }
}

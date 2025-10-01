public class ReverseStringBuilder {
    public static void main(String args[]) {
        StringBuilder sb = new StringBuilder("Vaibhav");
        // sb.reverse();

        // Custom reverse logic
        for (int i = 0; i < sb.length() / 2; i++) {
            int front = i;
            int back = sb.length() - i - 1;
            char frontCharacter = sb.charAt(front);
            char backCharacter = sb.charAt(back);
            sb.setCharAt(front, backCharacter);
            sb.setCharAt(back, frontCharacter);
        }
        System.out.println(sb.toString());
    }
}
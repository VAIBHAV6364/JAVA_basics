public class CommandLineInput {
    public static void main(String[] args) {
        // args[0] → integer
        // args[1] → character
        // args[2] → string

        // Convert the first argument to int
        int number = Integer.parseInt(args[0]);

        // Take the first character of the second argument
        char letter = args[1].charAt(0);

        // The third argument is a string directly
        String text = args[2];

        // Print them back
        System.out.println("Integer: " + number);
        System.out.println("Character: " + letter);
        System.out.println("String: " + text);
    }
}
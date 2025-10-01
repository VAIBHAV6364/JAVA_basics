import java.util.*;

public class MultilineString {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your multiline string. Press enter on an empty line to finish : ");

        StringBuilder multiline = new StringBuilder();
        String line;

        while (sc.hasNextLine()) {
            line = sc.nextLine();

            if (line.isEmpty()) {
                break; // Exit on empty line
            }

            multiline.append(line).append("\n");
        }
        sc.close();
        System.out.println("\n Your multiline string is: ");
        System.out.println(multiline.toString());
    }
}

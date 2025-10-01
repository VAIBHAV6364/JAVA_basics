import java.util.*;
public class Collections_FindAndDelete_Nth_Element_FromEnd {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        LinkedList<String> list = new LinkedList<String>();

        System.out.println("Enter the position N : ");
        int N = sc.nextInt();

        list.addFirst("10");
        list.addFirst("9");
        list.addFirst("8");
        list.addFirst("7");
        list.addFirst("6");
        list.addFirst("5");
        list.addFirst("4");
        list.addFirst("3");
        list.addFirst("2");
        list.addFirst("1");
        //to find size of linked list
        System.out.println("Size : "+list.size());

        int Size = list.size();

        if( N > Size || N <= 0){
            System.out.println("Invalid Number");
            return;
        }
        int DelPos = Size - N;

        System.out.println("Linked List before deletion : ");
        //to print data in a linked list
        for(int i = 0; i<list.size(); i++){
            System.out.print(list.get(i) + " --> ");  // .get(index) is used to retrieve the data in a linked list
        }
        System.out.println("null");

        System.out.println("Linked List after deletion : ");
        //to remove a particular element at a index
        list.remove(DelPos);   //starts from 0
        for(int i = 0; i<list.size(); i++){
            System.out.print(list.get(i) + " --> ");
        }
        System.out.println("null");

    }
}

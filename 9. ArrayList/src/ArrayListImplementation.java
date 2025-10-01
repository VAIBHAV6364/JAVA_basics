import java.util.ArrayList;
import java.util.Collections;
public class ArrayListImplementation {
    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<Integer>();

        //Adding elements to the ArrayList at the end
        list.add(0);
        list.add(2);
        list.add(3);
        list.add(6);

        //Getting elements of ArrayList
        int element = list.get(1);   //returns 2
        System.out.println(element);

        //To add elements at an index
        list.add(1,1);            //(index, element
        System.out.println(list);          //[0,1,2,3,6]

        //Modifying an existing element at an index
        list.set(0,5);               //index, new element
        System.out.println(list);   //[5,1,2,3,6]

        //Deleting  an element at an index
        list.remove(4);
        System.out.println(list);           // removes 6 from [5,1,2,3,6] => [5,1,2,3]

        //size of arraylist
        int size = list.size();
        System.out.println("Size of the ArrayList : "+size);     // displays 4

        //loops
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

        //Ascending sort
        Collections.sort(list);
        System.out.println(list);

        //to assign one arraylist to another
        ArrayList<Integer> newList = new ArrayList<Integer>(list);
        System.out.println("\nNew List :");
        System.out.println(newList);
    }
}

import java.util.*;
public class Collections_SLL {
    public static void main(String args[]){
        LinkedList<String> list = new LinkedList<String>();

        //to add at First
        list.addFirst("a");
        list.addFirst("is");
        System.out.println(list);

        list.addFirst("this");
        //to add at last
        list.addLast("Linked list");   // we can also use : list.add("Linked list");
        System.out.println(list);

        //to find size of linked list
        System.out.println("Size : "+list.size());

        //to print data in a linked list
        for(int i = 0; i<list.size(); i++){
            //if(list.get(i) == element)    // to search for an element
            System.out.print(list.get(i) + " --> ");  // .get(index) is used to retrieve the data in a linked list
        }
        System.out.println("null");

        //GET FIRST
        System.out.println("First element : "+ list.getFirst());

        //GET LAST
        System.out.println("Last element : "+ list.getLast());

        //GET
        System.out.println("Third element : "+ list.get(2));

        //to delete at first
        list.removeFirst();
        System.out.println(list);

        //to delete at last
        list.removeLast();
        System.out.println(list);

        //to remove a particular element at a index
        list.remove(1);   //starts from 0
        System.out.println(list);

    }
}

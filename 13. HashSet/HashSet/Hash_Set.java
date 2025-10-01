import java.util.HashSet;
import java.util.Iterator;
public class Hash_Set {
    public static void main(String args[]){
        //Creating
        HashSet<Integer> hashset = new HashSet<>();
        //only stores unique elements , inserting an already existing element does not inset it.

        //Inserting
        hashset.add(1);
        hashset.add(2);
        hashset.add(3);
        hashset.add(4);

        //Size
        int size = hashset.size();
        System.out.println("Size of Hashset : "+size);

        //Printing all elements of a Hashset
        System.out.println(hashset);

        //Iterator
        Iterator it = hashset.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        //Serach - contains
        if(hashset.contains(1)){
            System.out.println("Set comtains 1");
        }
        if(!hashset.contains(6)){
            System.out.println("Set does not contains 6");
        }

        //Delete
        hashset.remove(1);
        if(!hashset.contains(1)){
            System.out.println("1 has been removed!");
        }
    }
}

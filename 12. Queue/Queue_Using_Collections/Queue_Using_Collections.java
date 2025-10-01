import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
public class Queue_Using_Collections {
    public static void main(String args[]) {
        Queue<Integer> q = new LinkedList<>();
        Queue<String> q2 = new ArrayDeque<>();

        //ADDING ELEMENTs - Both add() and offer() can be used
        q.add(1);
        q.offer(2);
        q.add(3);
        q.offer(4);
        q.add(5);
        while(!q.isEmpty()){
            System.out.println(q.poll());
        }

        //REMOVING ELEMENTS - Both remove() and poll() can be used
        q.offer(10);
        q.add(20);
        System.out.println("PEEK : "+q.peek());
        while(!q.isEmpty()){
            System.out.println(q.poll());
        }

        q2.add("a");
        q2.offer("b");
        q2.add("c");
        q2.offer("d");
        while(!q2.isEmpty()){
            System.out.println(q2.poll());
        }

        q2.offer("vaibhav");
        q2.add(" R");
        System.out.println("PEEK : "+q2.peek());
        while(!q2.isEmpty()){
            System.out.println(q2.poll());
        }
    }
}

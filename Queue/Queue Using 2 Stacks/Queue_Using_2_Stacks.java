import java.util.*;
public class Queue_Using_2_Stacks {
    class Queue{
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        //IS EMPTY - if the first stack is empty
        public boolean isEmpty(){
            return s1.isEmpty();
        }

        //PUSH - push to stack 1 then pop all from s1 and push it all to s2 then push new to stack1 , then pop s2 fully and push that to s1
        public void enqueue(int data){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }

            s1.push(data);

            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }

        //POP - pop directly from stack 1
        public int dequeue(){
            if(s1.isEmpty()){
                System.out.println("The Queue using 2 Stacks is empty!");
                return -1;
            }

            return s1.pop();
        }

        //PEEK
        public int peek(){
            if(s1.isEmpty()){
                System.out.println("The Queue using 2 Stacks is empty!");
                return -1;
            }

            return s1.peek();
        }
    }

    public static void main(String args[]){
        Queue_Using_2_Stacks obj = new Queue_Using_2_Stacks();
        Queue q = obj.new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        System.out.println("PEEK : "+q.peek());
        while(!q.isEmpty()){
            System.out.println(q.dequeue());
        }
    }
}

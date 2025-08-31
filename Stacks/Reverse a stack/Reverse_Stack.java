import java.util.*;
public class Reverse_Stack {

        public void pushAtBottom(int data,Stack<Integer> s){
            if(s.isEmpty()){
                s.push(data);
                return;
            }
            int top = s.pop();
            pushAtBottom(data,s);
            s.push(top);
        }

        public void reverseStack(Stack<Integer> s){
            if(s.isEmpty()){
                return;
            }
            int top = s.pop();
            reverseStack(s);
            pushAtBottom(top, s);
        }

        public static void main(String args[]){
            Reverse_Stack obj = new Reverse_Stack();
            Stack<Integer> s = new Stack<>();
            s.push(1);
            s.push(2);
            s.push(3);
            System.out.println("Stack : "+ s);
            obj.reverseStack(s);
            System.out.println("\nReversed Stack : "+ s);
        }
}

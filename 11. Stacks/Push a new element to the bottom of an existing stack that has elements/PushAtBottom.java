import java.util.*;
public class PushAtBottom {
    public void pushAtBottom(int data, Stack<Integer> s){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(data, s);
        s.push(top);
    }

    public static void main(String args[]){
        PushAtBottom obj = new PushAtBottom();
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("Stack : "+ s);
        obj.pushAtBottom(4, s);
        System.out.println("\nNew Stack : "+ s);
    }
}

/*
Tracing pushAtBottom(4, s)
Call 1: stack = [1, 2, 3]
s.isEmpty() → false
top = 3
Recurse with stack [1, 2].

Call 2: stack = [1, 2]
s.isEmpty() → false
top = 2
Recurse with stack [1].

Call 3: stack = [1]
s.isEmpty() → false
top = 1
Recurse with stack [].

Call 4: stack = []
s.isEmpty() → true
Push 4 → stack becomes [4]
Return.

Unwinding recursion:

Back to Call 3: stack = [4], top = 1
Push 1 → stack = [4, 1]

Back to Call 2: stack = [4, 1], top = 2
Push 2 → stack = [4, 1, 2]

Back to Call 1: stack = [4, 1, 2], top = 3
Push 3 → stack = [4, 1, 2, 3]
 */
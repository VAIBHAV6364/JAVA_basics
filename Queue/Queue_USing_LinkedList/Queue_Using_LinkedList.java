public class Queue_Using_LinkedList {
    class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            next = null;
        }
    }

    class Queue{
        Node head = null;
        Node tail = null;

        //IS EMPTY
        public boolean isEmpty(){
            return head == null && tail == null;
        }

        //PUSH
        public void enqueue(int data){
            Node newNode = new Node(data);

            if(tail == null){
               tail = head = newNode;
            }

            tail.next = newNode;
            tail = newNode;
        }

        //POP
        public int dequeue(){
            if(isEmpty()){
                System.out.println("The Queue is empty");
                return -1;
            }

            //only one node
            int front = head.data;
            if(head == tail){
                tail = null;
            }

            //if more than one lement then as usual remove from the front
            head = head.next;
            return front;
        }

        //PEEK
        public int peek(){
            if(isEmpty()){
                System.out.println("The Queue is emplty!");
                return -1;
            }

            return head.data;
        }

        //Print
        public void printQueue(){
            if(isEmpty()){
                System.out.println("The Queue is emplty!");
                return ;
            }

            Node node = head;
            while(true){
                System.out.println("| "+node.data+" |");
                if(node == tail) return;
                node = node.next;
            }
        }
    }

    public static void main(String args[]){
        Queue_Using_LinkedList obj = new Queue_Using_LinkedList();
        Queue q = obj.new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.printQueue();
        System.out.println();
        System.out.println("Peek : "+q.peek());
        System.out.println();
        q.dequeue();
        System.out.println("After Dequeue : ");
        q.printQueue();

        System.out.println();
        while(!q.isEmpty()){
            System.out.println(q.dequeue());
        }
    }
}

public class Queue_Using_Array {
    class Queue{
        int arr[];
        int size;
        int rear = -1;

        Queue(int n){
            arr = new int[n];
            this.size = n;
        }

        //IS FULL
        public boolean isFull(){
            return rear == size - 1;
        }

        //IS EMPTY
        public boolean isEmpty(){
           return rear == -1;
        }

        //ADD ELEMENTS  -  O(1)
        public void enqueue(int data){
            //queue is full
            if(rear == size - 1){
                System.out.println("Queue is full!");
                return;
            }

            rear++;
            arr[rear] = data;
        }

        //REMOVE ELEMENTS - time complexity O(n)
        public int dequeue(){
            if(isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }

            int front = arr[0];
            for(int i = 0; i < rear; i++){
                arr[i] = arr[i+1];
            }
            rear--;

            return front;
        }

        //FRONT PEEK - O(1)
        public int peek(){
            if(isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }

            return arr[0];
        }

        //PRINT
        public void printQueue(){
            System.out.println();
            for(int i = 0; i <= rear; i++){
                System.out.println("| "+arr[i]+" |");
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        Queue_Using_Array obj = new Queue_Using_Array();
        Queue q = obj.new Queue(4);
        Queue q2 = obj.new Queue(2);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.printQueue();
        System.out.println("\nElement at 1 : "+q.peek());
        q.dequeue();
        System.out.println("After Dequeue : ");
        q.printQueue();

        //normal method to print
        while(!q.isEmpty()){
            System.out.println(q.dequeue());
        }

        q2.enqueue(10);
        q2.enqueue(20);
        System.out.println("Another Queue : ");
        q2.printQueue();
    }
}

public class CircularQueue_Using_Array {
    class Queue{
        int arr[];
        int size;
        int rear = -1;
        int front = -1;

        Queue(int n){
            arr = new int[n];
            this.size = n;
        }

        //IS FULL
        public boolean isFull(){
            return ((rear+1)%size) == front;
        }

        //IS EMPTY
        public boolean isEmpty(){
            return rear == -1 && front == -1;
        }

        //ADD ELEMENTS  -  O(1)
        public void enqueue(int data){
            //queue is full
            if(isFull()){
                System.out.println("Queue is full!");
                return;
            }

            //On First Element Add
            if(front == -1){
                front = 0;
            }
            rear = (rear+1) % size;
            arr[rear] = data;
        }

        //REMOVE ELEMENTS -  O(1)
        public int dequeue(){
            if(isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }

            int result = arr[front];
            //single element removal condition
            if(rear == front){
                front = - 1;
                rear = -1;
            }
            else{  // multiple elements
                front = (front + 1) % size;
            }

            return result;
        }

        //FRONT PEEK - O(1)
        public int peek(){
            if(isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }

            return arr[front];
        }

        //PRINT
        public void printQueue() {
            if(isEmpty()){
                System.out.println("Queue is Empty!");
                return;
            }

            System.out.println();
            int i = front;
            while(true){
                System.out.println("| " + arr[i] + " |");
                if(i == rear)
                    break;
                i = (i + 1) % size;
            }
            System.out.println();
        }

    }

    public static void main(String args[]){
        CircularQueue_Using_Array obj = new CircularQueue_Using_Array();
        Queue q = obj.new Queue(5);

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.printQueue();
        System.out.println("\nElement at 1 : "+q.peek());
        q.dequeue();
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(7);
        System.out.println();
        System.out.println("In Array :");
        for(int i = 0; i < q.size; i++){
            System.out.println("| "+q.arr[i]+" |");
        }
        System.out.println("\nAfter Dequeue : ");
        q.printQueue();

        //normal method to print
        while(!q.isEmpty()){
            System.out.println(q.dequeue());
        };
    }
}

import java.util.*;
    public class Custom_FindAndDelete_Nth_Element_FromEnd{
        //CREATING THE HEAD NODE
        Node head;

        private int size;

        Custom_FindAndDelete_Nth_Element_FromEnd(){
            this.size = 0;
        }

        class Node{
            String data;
            Node next;

            Node(String data){
                this.data = data;
                this.next = null;
                //whenever a node is created increment size by 1
                size++;
            }
        }

        // adding an element to the linked list
        //ADDING AT FIRST
        public void addFirst(String data){
            Node newNode = new Node(data);
            //If no node exists yet make the current newest node the first / HEAD
            if(head == null){
                head = newNode;
                return;
            }

            //if nodes already exist then
            newNode.next = head;
            head = newNode;
            return;
        }

        //ADDING AT LAST
        public void addLast(String data){
            Node newNode = new Node(data);

            if(head == null){
                head = newNode;
                return;
            }

            Node currNode = head;
            while(currNode.next != null){
                currNode = currNode.next;
            }

            currNode.next = newNode;
        }


        //DELETING THE FIRST NODE
        public void deleteFirst(){
            //CORNER CONDITION : i.e the linked list is empty
            if(head == null){
                System.out.println("The linked list is empty hence nothing to delete");
                return;
            }

            size--;
            head = head.next;
        }

        //DELETING THE LAST NODE
        public void deleteLast(){
            //Corner Condition
            if(head == null){
                System.out.println("THe lined list is empty hence nothing to delete");
                return;
            }

            size--;
            //Corner case : only one element exists
            if(head.next == null){
                head = null;
                return;
            }

            Node secondlast = head;
            Node last = head.next;
            while(last.next != null){
                last = last.next;
                secondlast = secondlast.next;
            }

            //make secondlast null
            secondlast.next = null;
        }


        // DELETE NODE AT A GIVEN INDEX
        public void deleteAtIndex(int index) {
            if (index < 0 || index > size) {
                System.out.println("Invalid index");
                return;
            }

            /*
            if (index == 0) { // first node

                deleteFirst();
                return;
            }

            if (index == size -1 ) { // last node
                deleteLast();
                return;
            }

            size--; // valid deletion, so reduce size
            // Traverse to the node just before the index
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            // Skip the node at index
            prev.next = prev.next.next;
            */
            size--;

            if(index == 0){
                head = head.next;
                return;
            }

            Node prev = head;
            int i = 0;
            for(i = 0; i < index; i++){
                prev = prev.next;
            }

            prev.next = prev.next.next;

        }

        //PRINTING THE NODES OF LINKED LIST
        public void printList(){
            if(head == null){
                System.out.println("There is no linked list , i.e Linked List is empty");
            }
            Node currNode = head;
            while(currNode != null){  // not currNode.next because then in that case last node won't be printed
                System.out.print("| "+ currNode.data + " |" + " --> ");
                currNode = currNode.next;
            }
            System.out.println("null");
        }

        //SIZE
        public int getSize(){
            return size;
        }

        public static void main(String args[]){
            Scanner sc = new Scanner(System.in);
            Singly_Linked_List list = new Singly_Linked_List();

            System.out.println("Enter Number of elements in the LL : ");
            int n = sc.nextInt();
            sc.nextLine(); // clear leftover newline

            System.out.println("Enter the Linked list elements : ");
            for(int i = 0 ; i < n; i++){
                list.addLast(sc.nextLine());
            }

            System.out.println("Enter nth position : ");
            int N = sc.nextInt();

            if(N > list.getSize() || N <= 0){
                System.out.println("Invalid Nth index only "+ n + " elements exist !");
                return;
            }

            System.out.println("\nThe Linked list : ");
            list.printList();
            System.out.println("Size : "+list.getSize());

            int DelPos = list.getSize() - N;
            list.deleteAtIndex(DelPos);

            System.out.println("After Deletion : ");
            list.printList();
        }
}

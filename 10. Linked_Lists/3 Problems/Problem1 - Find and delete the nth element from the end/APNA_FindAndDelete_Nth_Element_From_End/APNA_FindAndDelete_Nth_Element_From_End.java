import java.util.*;
public class APNA_FindAndDelete_Nth_Element_From_End {
        //CREATING THE HEAD NODE
        Node head;

        //VARIABLE TO TRACK LINKED LIST SIZE : increment when adding a node decrement when deleting a node hence no need to traverse whole linked list whenever size has to be tracked
        private int size;

    APNA_FindAndDelete_Nth_Element_From_End(){
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
            //If no node exists yet make the current newest node the first / HEAD
            if(head == null){
                head = newNode;
                return;
            }

            //finding the current node as HEAD and then pass through the linked list to reach the TAIL then add the new node
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
            //else move the head to next node making the first node / data unrecognisable to the linkedlist itself;
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

            //Traversing till Last and Second last node to make second last's next as null hence making the last node unreachable
            Node secondlast = head;
            Node last = head.next;
            while(last.next != null){
                last = last.next;
                secondlast = secondlast.next;
            }

            //make secondlast null
            secondlast.next = null;
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

            //print null after the last node is printed since TAIL points to null
            System.out.println("null");
        }

        //FUNCTION TO DELETE NTH ELEMENT FROM END
        public Node removeNthFromEnd(Node head, int n){
        if(head == null){
            return null;
        }

        int size = 0;
        Node curr = head;
        while(curr != null){
            size++;
            curr = curr.next;
        }

        if(n == size){
            return head.next;   //if n == size , then we need to remove first element , so return head's next will make second element null effectively making the first element unreachable
        }

        int indexToSearch = size - n;
        Node prev = head;
        int i = 1;
        while( i < indexToSearch){
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return head;
        }

        //SIZE
        public int getSize(){
            return size;
        }

        public static void main(String args[]){
            APNA_FindAndDelete_Nth_Element_From_End list = new APNA_FindAndDelete_Nth_Element_From_End();

            list.addLast("1");
            list.addLast("2");
            list.addLast("3");
            list.addLast("4");
            list.addLast("5");
            list.addLast("6");
            list.addLast("7");
            list.addLast("8");
            list.addLast("9");
            list.addLast("10");

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the value of n : ");
            int n = sc.nextInt();

            System.out.println("Linked list before deletion : ");
            list.printList();

            list.removeNthFromEnd(list.head, n);

            System.out.println("Linked list after deletion : ");
            list.printList();

        }
}

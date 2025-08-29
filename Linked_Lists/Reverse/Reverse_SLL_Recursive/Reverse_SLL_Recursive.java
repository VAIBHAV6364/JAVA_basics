public class Reverse_SLL_Recursive {
    Node head;

    //VARIABLE TO TRACK LINKED LIST SIZE : increment when adding a node decrement when deleting a node hence no need to traverse whole linked list whenever size has to be tracked
    private int size;

    Reverse_SLL_Recursive(){
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

    //Reverse a Linked list using Recursion
    public Node reverseRecursive(Node head){
        // Zero or only one node
        if(head == null || head.next == null){
            return head;
        }

        //else
        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args){
        Reverse_SLL_Recursive list = new Reverse_SLL_Recursive();
        list.addFirst("1");
        list.addLast("2");
        list.addLast("3");
        list.addLast("4");
        System.out.println("The original list : ");
        list.printList();
        System.out.println();
        System.out.println("Reversed List : ");
        list.head = list.reverseRecursive(list.head);
        list.printList();
    }
}

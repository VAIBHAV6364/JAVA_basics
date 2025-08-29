public class Singly_Linked_List{
    //CREATING THE HEAD NODE
    Node head;

    //VARIABLE TO TRACK LINKED LIST SIZE : increment when adding a node decrement when deleting a node hence no need to traverse whole linked list whenever size has to be tracked
    private int size;

    Singly_Linked_List(){
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


    // DELETE NODE AT A GIVEN INDEX
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index");
            return;
        }

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
    }


    // SEARCH FOR A PARTICULAR ELEMENT
    public int search(String key) {
        Node curr = head;
        int index = 0;

        while (curr != null) {
            if (curr.data.equals(key)) {
                return index; // found
            }
            curr = curr.next;
            index++;
        }

        return -1; // not found
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

    //SIZE
    public int getSize(){
        return size;
    }

    public static void main(String args[]){
        Singly_Linked_List list = new Singly_Linked_List();
        list.addFirst("Linked");
        list.addFirst("a");
        list.addLast("List");
        list.addLast("This");
        list.addLast("Delete this");
        list.addFirst("DeleteFirst");
        list.printList();
        System.out.println("Linked list size : "+ list.getSize());
        System.out.println();
        list.deleteFirst();
        list.printList();
        System.out.println("Linked list size : "+ list.getSize());
        System.out.println();
        list.deleteLast();
        list.printList();
        System.out.println("Linked list size : "+ list.getSize());
        System.out.println();

        list.addFirst("1");
        list.addFirst("2");
        list.addFirst("3");
        list.printList();
        System.out.println();
        // deleteAtIndex
        list.deleteAtIndex(2);     //starts at 0
        list.printList();
        System.out.println("Size after deleting : " + list.getSize());

        // search
        int pos = list.search("is");
        if (pos != -1)
            System.out.println("\"is\" found at index " + pos);
        else
            System.out.println("\"is\" not found");
    }
}




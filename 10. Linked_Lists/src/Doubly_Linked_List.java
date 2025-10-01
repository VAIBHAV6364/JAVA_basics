public class Doubly_Linked_List {
    // HEAD node (first node)
    Node head;

    // Track size of linked list
    private int size;

    Doubly_Linked_List() {
        this.size = 0;
    }

    // NODE CLASS (Doubly)
    class Node {
        String data;
        Node next;
        Node prev;

        Node(String data) {
            this.data = data;
            this.next = null;
            this.prev = null;
            size++;
        }
    }

    // ADD AT FIRST
    public void addFirst(String data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // ADD AT LAST
    public void addLast(String data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = newNode;
        newNode.prev = curr;
    }

    // DELETE FIRST
    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        size--;

        if (head.next == null) { // only one node
            head = null;
            return;
        }

        head = head.next;
        head.prev = null;
    }

    // DELETE LAST
    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        size--;

        if (head.next == null) { // only one node
            head = null;
            return;
        }

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        curr.prev.next = null;  // unlink forward reference
        curr.prev = null;       // unlink backward reference (important!)
    }

    // DELETE AT INDEX
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index");
            return;
        }

        if (index == 0) {
            deleteFirst();
            return;
        }

        if (index == size - 1) {
            deleteLast();
            return;
        }

        size--;

        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
    }

    // SEARCH
    public int search(String key) {
        Node curr = head;
        int index = 0;

        while (curr != null) {
            if (curr.data.equals(key)) {
                return index;
            }
            curr = curr.next;
            index++;
        }
        return -1;
    }

    // PRINT FORWARD
    public void printListForward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node curr = head;
        while (curr != null) {
            System.out.print("| " + curr.data + " | <--> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    // PRINT BACKWARD
    public void printListBackward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node curr = head;
        while (curr.next != null) { // go to tail
            curr = curr.next;
        }

        while (curr != null) {
            System.out.print("| " + curr.data + " | <--> ");
            curr = curr.prev;
        }
        System.out.println("null");
    }

    // SIZE
    public int getSize() {
        return size;
    }

    // MAIN
    public static void main(String args[]) {
        Doubly_Linked_List dll = new Doubly_Linked_List();

        dll.addFirst("Linked");
        dll.addFirst("a");
        dll.addLast("List");
        dll.addLast("This");
        dll.addLast("DeleteThis");
        dll.addFirst("DeleteFirst");

        System.out.println("Forward Traversal:");
        dll.printListForward();
        System.out.println("Backward Traversal:");
        dll.printListBackward();
        System.out.println("DLL Size : " + dll.getSize());

        System.out.println();
        dll.deleteFirst();
        dll.printListForward();
        System.out.println("DLL Size : " + dll.getSize());

        System.out.println();
        dll.deleteLast();
        dll.printListForward();
        System.out.println("DLL Size : " + dll.getSize());

        System.out.println();
        dll.addFirst("1");
        dll.addFirst("2");
        dll.addFirst("3");
        dll.printListForward();

        System.out.println();
        dll.deleteAtIndex(2); // starts at 0
        dll.printListForward();
        System.out.println("Size after deleting : " + dll.getSize());

        System.out.println();
        // search
        int pos = dll.search("is");
        if (pos != -1)
            System.out.println("\"is\" found at index " + pos);
        else
            System.out.println("\"is\" not found");
    }
}

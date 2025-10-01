public class Reverse_DLL_Iterative {
    Node head;
    private int size;

    Reverse_DLL_Iterative() {
        this.size = 0;
    }

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

    // ADD FIRST
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

    // ADD LAST
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

    // PRINT LIST
    public void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print("| " + curr.data + " | <--> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    // ITERATIVE REVERSE
    public void reverseIterative() {
        if (head == null || head.next == null) return;

        Node curr = head;
        Node temp = null;

        // swap prev and next for every node
        while (curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;

            curr = curr.prev;  // move forward using swapped link
        }

        // temp will be at the node before null (old tail), so update head
        if (temp != null) {
            head = temp.prev;
        }
    }

    public static void main(String[] args) {
        Reverse_DLL_Iterative list = new Reverse_DLL_Iterative();
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.addLast("4");

        System.out.println("Original DLL:");
        list.printList();

        list.reverseIterative();
        System.out.println("Reversed DLL (Iterative):");
        list.printList();
    }
}

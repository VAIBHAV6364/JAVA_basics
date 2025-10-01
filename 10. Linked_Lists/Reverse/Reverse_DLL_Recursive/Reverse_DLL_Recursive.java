public class Reverse_DLL_Recursive {
    Node head;
    private int size;

    Reverse_DLL_Recursive() {
        this.size = 0;
    }

    class Node {
        String data;
        Node next, prev;
        Node(String data) {
            this.data = data;
            this.next = null;
            this.prev = null;
            size++;
        }
    }

    // ADD LAST
    public void addLast(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null) curr = curr.next;
        curr.next = newNode;
        newNode.prev = curr;
    }

    // PRINT LIST
    public void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print("| " + curr.data + " | <-> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    // RECURSIVE REVERSE
    public Node reverseRecursive(Node node) {
        if (node == null) return null;

        // swap
        Node temp = node.prev;
        node.prev = node.next;
        node.next = temp;

        // if prev becomes null, this is new head
        if (node.prev == null) {
            return node;
        }

        // recurse with new prev
        return reverseRecursive(node.prev);
    }

    public static void main(String[] args) {
        Reverse_DLL_Recursive list = new Reverse_DLL_Recursive();
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.addLast("4");

        System.out.println("Original DLL:");
        list.printList();

        list.head = list.reverseRecursive(list.head);
        System.out.println("Reversed DLL (Recursive):");
        list.printList();
    }
}

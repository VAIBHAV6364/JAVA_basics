public class Apna_CycleCheck {
    Node head;
    private int Size;

    Apna_CycleCheck() {
        this.Size = 0;
    }

    class Node {
        String data;
        Node next;
        Node prev;

        Node(String data) {
            this.data = data;
            this.next = null;
            this.prev = null;
            Size++;
        }
    }

    // ADD FIRST
    public void addFirst(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        head.prev = newNode;
        newNode.next = head;
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

    // Cycle Check
    public boolean hasCycle(Node head) {
        Node hare = head;   // fast
        Node turtle = head; // slow
        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;
            if (hare == turtle) {
                return true;
            }
        }
        return false;
    }

    // Remove Cycle
    public void removeCycle(Node head) {
        Node hare = head;
        Node turtle = head;
        boolean cycleExists = false;

        // Step 1: Detect cycle
        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;
            if (hare == turtle) {
                cycleExists = true;
                break;
            }
        }

        if (!cycleExists) return; // no cycle, nothing to remove

        // Step 2: Reset turtle to head
        turtle = head;

        // Step 3: Move both one step at a time until they meet at cycle start
        while (turtle.next != hare.next) {
            turtle = turtle.next;
            hare = hare.next;
        }

        // Step 4: Break the cycle
        hare.next = null;
    }

    // PRINT
    public void printList() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }
        Node curr = head;
        for (int i = 0; i < Size; i++) {
            System.out.print("|" + curr.data + "| <--> ");
            curr = curr.next;
            if (curr == null) break; // stop if list ends
        }
        System.out.println("null");
    }

    // GET size
    public int getSize() {
        return Size;
    }

    public static void main(String args[]) {
        Apna_CycleCheck list = new Apna_CycleCheck();
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.addLast("4");
        list.addLast("5");

        System.out.println("Linked List:");
        list.printList();

        // Manually creating a cycle: last node points back to node 2
        list.head.next.next.next.next.next = list.head.next;

        // Check for cycle
        System.out.println("Has Cycle? " + list.hasCycle(list.head));

        // Remove cycle
        list.removeCycle(list.head);

        // Check again
        System.out.println("Has Cycle after removal? " + list.hasCycle(list.head));

        // Print again (should terminate properly now)
        System.out.println("Linked List after cycle removal:");
        list.printList();
    }
}

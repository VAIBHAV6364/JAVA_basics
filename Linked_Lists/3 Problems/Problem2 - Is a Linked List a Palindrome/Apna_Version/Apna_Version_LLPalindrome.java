import java.util.*;
public class Apna_Version_LLPalindrome {
    Node head;
    private int Size;

    Apna_Version_LLPalindrome(){
        this.Size = 0;
    }

    class Node{
        String data;
        Node next;
        Node prev;

        Node(String data){
            this.data = data;
            this.next = null;
            this.prev = null;
            Size++;
        }
    }

    //ADD FIRST
    public void addFirst(String data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            return;
        }

        head.prev = newNode;
        newNode.next = head;
        head = newNode;
    }

    //ADD LAST
    public void addLast(String data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            return;
        }

        Node curr = head;
        while(curr.next != null){
            curr = curr.next;
        }

        curr.next = newNode;
        newNode.prev = curr;
    }

    //REVERSE FUNCTION
    public Node reverse(Node head){
        Node prev = null;
        Node curr = head;

        while(curr != null){
            Node Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }
        return prev;    //New Head
    }

    //FINDING THE MIDDLE -----> HARE TURTLE APPROACH
    public Node findMiddle(Node head){
        Node hare = head;
        Node turtle = head;

        while(hare.next != null && hare.next.next != null){
            hare = hare.next.next;
            turtle = turtle.next;
        }
        System.out.println("Middle : "+turtle.data);
        return turtle;
    }

    //PALINDROME CHECK
    public boolean isPalindrome(Node head){
        if(head == null || head.next == null){
            return true;
        }

        Node middle = findMiddle(head);    //!st Half's end

        Node secondHalfStart = reverse(middle.next);

        Node firstHalfStart = head;
        while(secondHalfStart != null) {
            if(firstHalfStart.data != secondHalfStart.data){
                return false;
            }
            firstHalfStart = firstHalfStart.next;
            secondHalfStart = secondHalfStart.next;
        }
        return true;
    }


    //PRINT
    public void printList(){
        if(head == null){
            System.out.println("The list is empty");
            return;
        }

        Node curr = head;
        for(int i = 0; i < Size; i++){
            System.out.print("|"+ curr.data +"| <--> ");
            curr = curr.next;
        }
        System.out.println("node");
    }


    //GET size
    public int getSize(){
        return Size;
    }

    public static void main(String args[]){
        Apna_Version_LLPalindrome List = new Apna_Version_LLPalindrome();
        List.addLast("r");
        List.addLast("e");
        List.addLast("c");
        List.addLast("e");
        List.addLast("c");
        List.addLast("a");
        List.addLast("r");

        System.out.println("Linked List : ");
        List.printList();

        System.out.println("Is it a palindrome : ");
        if(List.isPalindrome(List.head)){
            System.out.println("Yes!");
        }
        else{
            System.out.println("No!");
        }
    }
}

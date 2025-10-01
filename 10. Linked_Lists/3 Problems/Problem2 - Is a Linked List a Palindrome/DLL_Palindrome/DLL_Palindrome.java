public class DLL_Palindrome {
    Node head;
    private int Size;

    DLL_Palindrome(){
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

    //FUNCTION TO CHECK LINKED LIST IS A PALINDROME OR NOT
    public boolean checkPalindrome(int Size){
        if(head == null){
            System.out.println("The list is empty");
            return false;
        }

        if(head.next == null){
            return true;
        }

        Node lastNode = head;
        Node currNode = head;
        while(lastNode.next != null){
            lastNode = lastNode.next;
        }

        for(int i = 1; i <= (Size/2); i++){
            if(!currNode.data.equals(lastNode.data)){
                return false;
            }
            currNode = currNode.next;
            lastNode = lastNode.prev;
        }
        return true;
    }

    //GET SIZE
    public int getSize(){
        return Size;
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


    public static void main(String args[]){
        DLL_Palindrome dlList = new DLL_Palindrome();
        dlList.addLast("r");
        dlList.addLast("a");
        dlList.addLast("c");
        dlList.addLast("e");
        dlList.addLast("c");
        dlList.addLast("a");
        dlList.addLast("r");

        System.out.println("Doubly Linked List : ");
        dlList.printList();

        System.out.println("Is it a palindrome : ");
        if(dlList.checkPalindrome(dlList.getSize())){
            System.out.println("Yes!");
        }
        else{
            System.out.println("No!");
        }
    }
}

public class PrintBtwXandY {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    // INSERTION
    public static Node insert(Node root, int val){
        if(root == null)
            return new Node(val);

        if(root.data > val)
            root.left = insert(root.left, val);

            // duplicate elements
        /*
        else
            root.right  = insert(root.right, val);
         */


            // NO DUPLICATES
        else if (root.data < val)
            root.right = insert(root.right, val);

        return root;
    }

    // INORDER
    public void inOrder (Node root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    // PRINT BTW X AND Y INCLUSIVE
    public static  void printInRange(Node root, int X, int Y){
        if(root == null)
            return;

        if(root.data >= X && root.data <= Y){
            printInRange(root.left, X, Y);
            System.out.print(root.data + " ");
            printInRange(root.right, X, Y);
        }

        else if(root.data >= Y){
            printInRange(root.left, X, Y);
        }

        else{   // if root.data <= X
            printInRange(root.right, X, Y);
        }
    }

    public static void main(String args[]){
        PrintBtwXandY bst = new PrintBtwXandY();
        int values[] = {2,4,9,2,6,3,7,1,10,40,20};
        Node root = null;
        for(int val : values)
            root = bst.insert(root, val);

        System.out.println("In-order : ");
        bst.inOrder(root);

        System.out.println("\nPrint In Range : ");
        bst.printInRange(root, 100, 500);
    }
}

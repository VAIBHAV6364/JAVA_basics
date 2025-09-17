import java.sql.SQLOutput;
import java.util.*;

class Tree_Node{
    int val;
    Tree_Node left;
    Tree_Node right;

    Tree_Node(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class CountBT_Nodes {
    Tree_Node root;

    // INSERT INTO BST
    public void insert(int val){
        root = insertRec(root, val);
    }

    private Tree_Node insertRec(Tree_Node root, int val){
        if(root == null)
            return new Tree_Node(val);

        if(val < root.val)
            root.left = insertRec(root.left, val);

        else if(val > root.val)
            root.right = insertRec(root.right, val);

        return root;
    }

    // INORDER TRAVERSAL
    public void inOrder(Tree_Node root){
        if(root == null )
            return;

        inOrder(root.left);
        System.out.print(root.val + ", ");
        inOrder(root.right);
    }

    // COUNT THE NUMBER OF NODES
    public static int countNodes(Tree_Node root){
        if(root == null)
            return 0;

        int leftNodes = countNodes(root.left);
        int rightNodes =  countNodes(root.right);
        return leftNodes + rightNodes + 1;
    }

    public static void main(String args[]){
        CountBT_Nodes bst = new CountBT_Nodes();
        int[] values = {50,30,70,20,40,60,80};

        for(int val : values)
            bst.insert(val);

        System.out.println("INORDER TRAVERSAL : ");
        bst.inOrder(bst.root);
        System.out.println("\n");

        System.out.println(" Number of Nodes : " + bst.countNodes(bst.root));
    }
}

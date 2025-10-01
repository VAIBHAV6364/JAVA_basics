import java.util.*;
public class BST_DEMO {
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

    // PREORDER
    public void preOrder(Node root){
        if(root != null){
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    // POSTORDER
    public void postOrder(Node root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }


    // LEVEL ORDER (BFS)
    public void levelOrder(Node root){
        if(root == null)
            return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node node = q.poll();
            System.out.print(node.data + " ");

            if(node.left != null)
                q.add(node.left);
            if(node.right != null)
                q.add(node.right);
        }
    }


    // SEARCH
    public boolean search(Node root, int key){
        if(root == null)
            return false;

        if(root.data == key)
            return true;

        else if(key < root.data)
            return search(root.left, key);

        else
            return search(root.right, key);
    }

    public static void main(String args[]){
        BST_DEMO bst = new BST_DEMO();
        int values[] = {2,4,9,2,6,3,7,1,10,40,20};
        Node root = null;
        for(int val : values)
            root = bst.insert(root, val);

        System.out.println("In-order : ");
        bst.inOrder(root);

        System.out.println("\n Pre Order : ");
        bst.preOrder(root);

        System.out.println("\n Post Order : ");
        bst.postOrder(root);

        System.out.println("\n Level Order : ");
        bst.levelOrder(root);

        int key = 100;
        boolean result = bst.search(root, key);
        System.out.println("\n\n Search for "+ key + " : "+ result);
    }
}

import java.util.*;
public class PrintRootToLeafPaths {
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


    // Print all paths from root to all leaf nodes
    public static void printRoot2LeafPath(Node root, ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);

        // LEAF
        if(root.left == null && root.right == null){
            for(int i = 0; i < path.size(); i++) {
                if(i == path.size()-1){
                    System.out.print(path.get(i));
                } else {
                    System.out.print(path.get(i) + " -->  ");
                }
            }
            System.out.println("\n");
        }
        // NON LEAF NODES
        printRoot2LeafPath(root.left, path);
        printRoot2LeafPath(root.right, path);
        path.remove(path.size()-1);
    }

    public static void main(String args[]){
        PrintRootToLeafPaths bst = new PrintRootToLeafPaths();
        int values[] = {2,4,9,2,6,3,7,1,10,40,20};
        Node root = null;
        for(int val : values)
            root = bst.insert(root, val);

        System.out.println("In-order : ");
        bst.inOrder(root);

        System.out.println("\nAll Paths from Root to Leaf Nodes : ");
        printRoot2LeafPath(root, new ArrayList<Integer>());
    }
}

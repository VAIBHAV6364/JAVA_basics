import java.util.*;
public class Delete_in_BST {
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

            else if(root.data > val)
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


        // DELETE A NODE
        public Node delete(Node root, int val){
            if(root == null)
                return null;

            if(root.data > val)
                root.left = delete(root.left, val);

            else if(root.data < val)
                root.right = delete(root.right, val);

            else{  // root.data == val
                // case 1 : the Node to be deleted is a leaf node
                if(root.left == null && root.right == null)
                    return null;

                // case 2 : it has only one child
                if(root.left == null)
                    return root.right;
                else if(root.right == null)
                    return root.left;

                //case 3 : the node to be deleted has two children
                Node IS = inorderSuccessor(root.right);    // IS is the inorder successor that is the node in the right subtree with no left child
                root.data = IS.data;
                root.right = delete(root.right, IS.data);
            }
            return root;
        }


        public static Node inorderSuccessor(Node root) {
            // Traverse in the right subtree going left left left till there is left
            while(root.left != null) {
                root = root.left;
            }
            return root;
        }


    // PRETTY PRINT TREE (with └── and ├──)
    public void printPretty(Node root, String prefix, boolean isLeft) {
        if (root == null) return;

        // Print current node
        System.out.println(prefix + (isLeft ? "├── " : "└── ") + root.data);

        // Recurse left and right children
        printPretty(root.left, prefix + (isLeft ? "│   " : "    "), true);
        printPretty(root.right, prefix + (isLeft ? "│   " : "    "), false);
    }


    public static void main(String args[]){
        Delete_in_BST bst = new Delete_in_BST();
        int values[] = {2,4,9,2,6,3,7,1,10,40,20};
        Node root = null;
        for(int val : values)
            root = bst.insert(root, val);

        System.out.println("In-order : ");
        bst.inOrder(root);
        System.out.println();
        System.out.println("\nTree representation:");
        bst.printPretty(root, "", false);


        bst.delete(root, 3);

        System.out.println("\nIn-order after deletion : ");
        bst.inOrder(root);
        System.out.println();
        System.out.println("\nTree representation:");
        bst.printPretty(root, "", false);

    }
}

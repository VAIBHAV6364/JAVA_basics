import java.util.*;
public class BT_Orders {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        //firstly idx if -1 it means the tree is empty
        static int idx = -1;
        public static Node buildTree(int nodes[]) {
            idx++;       // creation of new node increse index

            if(nodes[idx] == -1){
                return null;       // if the order contains -1 then null
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);   // recursively build subtree
            newNode.right = buildTree(nodes);    // recursively build subtree

            return newNode;
        }
    }

    // PRE-ORDER TRAVERSAL (DFS)
    public static void preOrder(Node root){
        if(root == null){
            return;          // if it reaches leaf then print nothing
        }
        System.out.print(root.data + ", ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // IN-ORDER TRAVERSAL (DFS)
    public static void inOrder(Node root){
        if(root == null)
            return;

        inOrder(root.left);
        System.out.print(root.data + ", ");
        inOrder(root.right);
    }

    // POST-ORDER TRAVERSAL (DFS)
    public static void postOrder(Node root){
        if(root == null){
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + ", ");
    }

    // LEVEL-ORDER TRAVERSAL (BFS)
    public static void levelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);  // root means only one node so after that move to next level by adding "null"

        while(!q.isEmpty()){
            Node curr = q.remove();

            if(curr == null){
                System.out.println();    // printing next level nodes in next line

                if(q.isEmpty()){
                    break;
                } else{
                    q.add(null);
                }
            }
            else{
                System.out.print(curr.data + " ");
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
    }

    public static void main(String args[]){
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);  // returns root node

        System.out.println(root.data);   // prints data at root

        // Printing PRE-ORDER
        System.out.println("PRE-ORDER TRAVERSAL : ");
        preOrder(root);
        System.out.println();
        System.out.println();

        // Printing IN-ORDER
        System.out.println("IN-ORDER TRAVERSAL : ");
        inOrder(root);
        System.out.println();
        System.out.println();

        // Printing POST-ORDER
        System.out.println("POST-ORDER TRAVERSAL : ");
        postOrder(root);
        System.out.println();
        System.out.println();

        // Printing LEVEL-ORDER
        System.out.println("LEVEL-ORDER TRAVERSAL : ");
        levelOrder(root);
        System.out.println();
    }
}

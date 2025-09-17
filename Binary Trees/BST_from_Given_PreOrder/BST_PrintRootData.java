public class BST_PrintRootData {
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

    public static void main(String args[]){
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);  // returns root node

        System.out.println(root.data);   // prints data at root
    }
}

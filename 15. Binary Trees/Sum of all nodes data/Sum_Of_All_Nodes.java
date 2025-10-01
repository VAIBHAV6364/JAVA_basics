public class Sum_Of_All_Nodes {
    Tree_Node root;

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
    public static int sumOfNodes(Tree_Node root){
        if(root == null)
            return 0;

        int leftSubTreeSum = sumOfNodes(root.left);
        int rightSubTreeSum =  sumOfNodes(root.right);
        return leftSubTreeSum + rightSubTreeSum + root.val;
    }

    public static void main(String args[]){
        Sum_Of_All_Nodes bst = new Sum_Of_All_Nodes();
        int[] values = {50,30,70,20,40,60,80};

        for(int val : values)
            bst.insert(val);

        System.out.println("INORDER TRAVERSAL : ");
        bst.inOrder(bst.root);
        System.out.println("\n");

        System.out.println(" Sum of Nodes : " + bst.sumOfNodes(bst.root));
    }
}

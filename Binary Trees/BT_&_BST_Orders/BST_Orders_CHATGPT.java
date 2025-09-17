import java.util.*;

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

            TreeNode(int val){
                this.val = val;
                this.left = null;
                this.right = null;
            }
    }

public class BST_Orders_CHATGPT {
    TreeNode root;

    // INSERT INTO BST
    public void insert(int val){
        root = insertRec(root, val);
    }

    private TreeNode insertRec(TreeNode root, int val){
        if(root == null)
            return new TreeNode(val);

        if(val < root.val)
            root.left = insertRec(root.left, val);

        else if(val > root.val)
            root.right = insertRec(root.right, val);

        return root;
    }

    // INORDER TRAVERSAL
    public void inOrder(TreeNode root){
        if(root == null )
            return;

        inOrder(root.left);
        System.out.print(root.val + ", ");
        inOrder(root.right);
    }

    // PREORDER TRAVERSAL
    public void preOrder(TreeNode root){
        if(root == null)
            return;

        System.out.print(root.val + ", ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // POSTORDER TRAVERSAL
    public void postOrder(TreeNode root){
        if(root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + ", ");
    }

    // LEVEL ORDER TRAVERSAL (BFS)
    public void levelOrder(TreeNode root){
        if(root == null)
            return;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            System.out.print(curr.val + " ");
            if(curr.left != null)
                q.add(curr.left);
            if(curr.right != null)
                q.add(curr.right);
        }
    }

    public static void main(String args[]){
        BST_Orders_CHATGPT bst = new BST_Orders_CHATGPT();
        int[] values = {50,30,70,20,40,60,80};

        for(int val : values)
            bst.insert(val);

        System.out.println("INORDER TRAVERSAL : ");
        bst.inOrder(bst.root);
        System.out.println("\n");

        System.out.println("PREORDER TRAVERSAL : ");
        bst.preOrder(bst.root);
        System.out.println("\n");

        System.out.println("POSTORDER TRAVERSAL : ");
        bst.postOrder(bst.root);
        System.out.println("\n");

        System.out.println("LEVEL ORDER TRAVERSAL : ");
        bst.levelOrder(bst.root);
        System.out.println("\n");
    }
}

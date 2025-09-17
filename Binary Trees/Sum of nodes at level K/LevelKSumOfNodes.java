import java.util.*;

public class LevelKSumOfNodes {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    // BFS TO CALCULATE THE SUM OF NODES AT LEVEL K
    public int sumAtLevelK(TreeNode root, int k) {
        if (root == null)
            return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int level = 0;
        int sum = 0;

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr == null) {
                level++;
                if (q.isEmpty())
                    break;
                q.add(null);
            } else {
                if (level == k) {
                    sum += curr.val;
                }
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
        }
        return sum;
    }

    // INSERT INTO BST
    TreeNode root;

    public void insert(int val) {
        root = insertRec(root, val);
    }

    private TreeNode insertRec(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);

        if (val < root.val)
            root.left = insertRec(root.left, val);
        else if (val > root.val)
            root.right = insertRec(root.right, val);

        return root;
    }

    public static void main(String args[]) {
        LevelKSumOfNodes bst = new LevelKSumOfNodes();

        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int val : values)
            bst.insert(val);

        int k = 2;
        System.out.println("Sum at level " + k + " = " + bst.sumAtLevelK(bst.root, k));
    }
}

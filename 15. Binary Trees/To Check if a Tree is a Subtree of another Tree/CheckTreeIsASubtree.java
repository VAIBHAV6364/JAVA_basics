public class CheckTreeIsASubtree {

    // TREE NODE CLASS
    static class Tree_Node {
        int val;
        Tree_Node left, right;

        Tree_Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    // MAIN FUNCTION TO CHECK IF subTreeRoot IS A SUBTREE OF root
    public boolean isSubTree(Tree_Node root, Tree_Node subTreeRoot) {
        // CHECK IF THE SUB TREE IS ACTUALLY NULL THEN TRUE AS ALL TREES HAVE NULL BELOW LEAF NODE
        // if subtree is null -> always true
        if (subTreeRoot == null)
            return true;

        // IF ONLY THE MAIN TREE IS NULL ITS FALSE BEACUSE WE CANT COMAPRE
        // if main tree is null -> false
        if (root == null)
            return false;

        // if root values match, check identical
        if (root.val == subTreeRoot.val) {
            if (isIdentical(root, subTreeRoot)) {
                return true;
            }
        }

        // else check recursively in left and right
        return isSubTree(root.left, subTreeRoot) || isSubTree(root.right, subTreeRoot);
    }

    // CHECK IF TWO TREES ARE IDENTICAL
    public boolean isIdentical(Tree_Node root, Tree_Node subTreeRoot) {
        // if only 1 node was given hence already compared in isSubTree and below are null that is it was a leaf node that was compared in isSubTree
        if (root == null && subTreeRoot == null)
            return true;

        if (root == null || subTreeRoot == null)
            return false;

        // IF BOTH NODES VALUES ARE SAME MOVE TO CHECKING LEFT AND RIGHT SUBTREES OF BOTH TREE AND SUBTREE
        if (root.val == subTreeRoot.val)
            return isIdentical(root.left, subTreeRoot.left) && isIdentical(root.right, subTreeRoot.right);

        return false;
    }

    // UTILITY FUNCTION TO CREATE A TEST TREE
    public Tree_Node insert(Tree_Node root, int val) {
        if (root == null) {
            return new Tree_Node(val);
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    // DRIVER CODE
    public static void main(String[] args) {
        CheckTreeIsASubtree obj = new CheckTreeIsASubtree();

        // MAIN TREE
        Tree_Node root = null;
        root = obj.insert(root, 10);
        root = obj.insert(root, 5);
        root = obj.insert(root, 15);
        root = obj.insert(root, 3);
        root = obj.insert(root, 7);
        root = obj.insert(root, 12);
        root = obj.insert(root, 18);

        // SUBTREE
        Tree_Node subRoot = null;
        subRoot = obj.insert(subRoot, 15);
        subRoot = obj.insert(subRoot, 12);
        subRoot = obj.insert(subRoot, 18);

        if (obj.isSubTree(root, subRoot)) {
            System.out.println("YES - subRoot is a subtree of root");
        } else {
            System.out.println("NO - subRoot is NOT a subtree of root");
        }
    }
}

/*

Main Tree (root)

Insert order: 10, 5, 15, 3, 7, 12, 18

           10
          /  \
        5      15
       / \    /  \
      3   7  12   18

SubTree (subRoot)

Insert order: 15, 12, 18

       15
      /  \
    12    18


 */
public class Height_Of_Tree {
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
            System.out.print(root.val + " ");
            inOrder(root.right);
        }

        // HEIGHT OF A TREE
        public static int heightOfTree(Tree_Node root){
            if(root == null)
                return 0;

            int leftHeight = heightOfTree(root.left);
            int rightHeight =  heightOfTree(root.right);

            int currHeight = Math.max(leftHeight, rightHeight) + 1;

            return currHeight;
        }

        public static void main(String args[]){
            Height_Of_Tree bst = new Height_Of_Tree();
            int[] values = {50,30,70,20,40,60,80,1,1,2};

            for(int val : values)
                bst.insert(val);

            System.out.println("INORDER TRAVERSAL : ");
            bst.inOrder(bst.root);
            System.out.println("\n");

            System.out.println("Height of the Tree : " + bst.heightOfTree(bst.root));
        }
    }

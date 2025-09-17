public class Tree_Diameter_Through_Root_Nsqr {
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

        // DIAMETER OF A TREE THROUGH ROOT NODE OF N^2 TIME COMPLEXITY
    public static int treeDiameter(Tree_Node root){
            if(root == null)
                return 0;

            int dia1 = treeDiameter(root.left);
            int dia2 = treeDiameter(root.right);
            int dia3 = heightOfTree(root.left) + heightOfTree(root.right) + 1;

            return Math.max(dia3, Math.max(dia1, dia2));
    }

        public static void main(String args[]){
            Tree_Diameter_Through_Root_Nsqr bst = new Tree_Diameter_Through_Root_Nsqr();
            int[] values = {50,30,70,20,40,60,80,1,1,2};

            for(int val : values)
                bst.insert(val);

            System.out.println("INORDER TRAVERSAL : ");
            bst.inOrder(bst.root);
            System.out.println("\n");

            System.out.println("Diameter of the Tree : " + bst.treeDiameter(bst.root));
        }
    }


    // EXPLANATION
/*

📏 Step 1: Heights of All Subtrees

We need heights because diameter uses them.
Height = longest path from a node to its deepest leaf.

height(2) = 1

height(1) = max(0,1) + 1 = 2

height(20) = max(2,0) + 1 = 3

height(40) = 1

height(30) = max(3,1) + 1 = 4

height(60) = 1

height(80) = 1

height(70) = max(1,1) + 1 = 2

height(50) = max(4,2) + 1 = 5

✅ Confirmed.


📏 Step 2: Diameter Calculation (Bottom-Up)

Now compute diameter for each node:

🌱 At Node 2

Left = 0, Right = 0

dia(2) = max(0,0, 0+0+1) = 1

🌱 At Node 1

dia(left) = 0 (no left)

dia(right) = 1 (from node 2)

height(left)+height(right)+1 = 0 + 1 + 1 = 2

dia(1) = max(0,1,2) = 2

🌱 At Node 20

dia(left) = 2 (from node 1)

dia(right) = 0

height(left)+height(right)+1 = 2 + 0 + 1 = 3

dia(20) = max(2,0,3) = 3

🌱 At Node 40

dia(40) = 1

🌱 At Node 30

dia(left) = 3 (from 20)

dia(right) = 1 (from 40)

height(left)+height(right)+1 = 3 + 1 + 1 = 5

dia(30) = max(3,1,5) = 5

🌱 At Node 60

dia(60) = 1

🌱 At Node 80

dia(80) = 1

🌱 At Node 70

dia(left) = 1 (60)

dia(right) = 1 (80)

height(left)+height(right)+1 = 1 + 1 + 1 = 3

dia(70) = max(1,1,3) = 3

🌱 At Node 50 (Root)

dia(left) = 5 (from 30)

dia(right) = 3 (from 70)

height(left)+height(right)+1 = 4 + 2 + 1 = 7

dia(50) = max(5,3,7) = 7

 */

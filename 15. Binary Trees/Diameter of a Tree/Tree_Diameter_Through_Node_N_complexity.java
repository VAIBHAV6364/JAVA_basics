public class Tree_Diameter_Through_Node_N_complexity {
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



        // DIAMETER OF A TREE
        static class TreeInfo{
            int ht;
            int diam;

            TreeInfo(int ht, int diam){
                this.ht = ht;
                this.diam = diam;
            }
        }

        public static TreeInfo diameter2(Tree_Node root){
            if(root == null)
                return new TreeInfo(0,0);

            TreeInfo left = diameter2(root.left);
            TreeInfo right = diameter2(root.right);

            int myHeight = Math.max(left.ht, right.ht) + 1;

            int dia1 = left.diam;
            int dia2 = right.diam;
            int dia3 = left.ht + right.ht + 1;

            int mydia = Math.max(Math.max(dia1, dia2) , dia3);

            TreeInfo myInfo = new TreeInfo(myHeight, mydia);
            return myInfo;
        }



        public static void main(String args[]){
            Tree_Diameter_Through_Node_N_complexity bst = new Tree_Diameter_Through_Node_N_complexity();
            int[] values = {50,30,70,20,40,60,80,1,1,2};

            for(int val : values)
                bst.insert(val);

            System.out.println("INORDER TRAVERSAL : ");
            bst.inOrder(bst.root);
            System.out.println("\n");

            TreeInfo result = bst.diameter2(bst.root);
            System.out.println("Diameter of the Tree : " + result.diam);
            System.out.println("Height of the Tree : " + result.ht);

        }
    }


// EXPLANATION

/*

🔎 Tracing on Example Tree

Take the same tree:

                 50
               /    \
             30      70
            /  \    /  \
          20   40  60  80
         /
        1
         \
          2

🌱 Leaf Node (2)

left = (0,0)

right = (0,0)

height = max(0,0)+1 = 1

dia = max(0,0, 0+0+1=1) = 1
👉 return (1,1)

🌱 Node (1)

left = (0,0)

right = (1,1) (from node 2)

height = max(0,1)+1 = 2

dia = max(0,1, 0+1+1=2) = 2
👉 return (2,2)

🌱 Node (20)

left = (2,2) (from 1)

right = (0,0)

height = max(2,0)+1 = 3

dia = max(2,0, 2+0+1=3) = 3
👉 return (3,3)

🌱 Node (40)

left = (0,0), right = (0,0)

height = 1, dia = 1
👉 (1,1)

🌱 Node (30)

left = (3,3) (20)

right = (1,1) (40)

height = max(3,1)+1 = 4

dia = max(3,1, 3+1+1=5) = 5
👉 return (4,5)

🌱 Node (60)

(1,1)

🌱 Node (80)

(1,1)

🌱 Node (70)

left = (1,1) (60)

right = (1,1) (80)

height = max(1,1)+1 = 2

dia = max(1,1, 1+1+1=3) = 3
👉 return (2,3)

🌱 Root (50)

left = (4,5) (30)

right = (2,3) (70)

height = max(4,2)+1 = 5

dia = max(5,3, 4+2+1=7) = 7
👉 return (5,7)

✅ Final Answer

Height of tree = 5

Diameter of tree = 7

Longest path: 2 → 1 → 20 → 30 → 50 → 70 → 80

 */
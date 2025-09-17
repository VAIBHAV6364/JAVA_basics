public class Search_in_BST {
    static class Node{
        int data;
        BST_DEMO.Node left;
        BST_DEMO.Node right;

        Node(int data){
            this.data = data;
        }
    }

    // INSERTION
    public static BST_DEMO.Node insert(BST_DEMO.Node root, int val){
        if(root == null)
            return new BST_DEMO.Node(val);

        if(root.data > val)
            root.left = insert(root.left, val);

            // duplicate elements
        /*
        else
            root.right  = insert(root.right, val);
         */


            // NO DUPLICATES
        else if (root.data < val)
            root.right = insert(root.right, val);

        return root;
    }

    // SEARCH
    public boolean search(BST_DEMO.Node root, int key){
        if(root == null)
            return false;

        if(root.data == key)
            return true;

        else if(key < root.data)
            return search(root.left, key);

        else
            return search(root.right, key);
    }

    public static void main(String args[]){
        Search_in_BST bst = new Search_in_BST();
        int values[] = {2,4,9,2,6,3,7,1,10,40,20};
        BST_DEMO.Node root = null;
        for(int val : values)
            root = bst.insert(root, val);

        int key = 100;
        boolean result = bst.search(root, key);
        System.out.println("\n\n Search for "+ key + " : "+ result);
    }
}

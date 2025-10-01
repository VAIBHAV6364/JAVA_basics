/*

    LONGEST WORD WITH ALL PREFIXES

    find the longest string in words such that every prefix of it is also in words.
    words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
    ans = "apple

 */

public class LongestWordWithAllPrefixes {
    class TrieNode {
        TrieNode[] children;
        boolean eow;

        public TrieNode(){
            children = new TrieNode[26];  // a to z
            // THE ROOT NODE IS EMPTY AND ALL OTHER NODES WHEN CREATED CONTAIN NULL IN ARRAY
            for(int i = 0; i < 26; i++)
                children[i] = null;

            eow = false;
        }


        // for 256 characters change this and do some change further in the program
            /*

            children = new TrieNode[256];
            int idx = (int) word.charAt(i);   // ASCII value (0–255)

             */
    }

    TrieNode root = new TrieNode();

    // INSERTION OF A WORD INTO TRIE
    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){   // O(L)
            int idx = word.charAt(i)-'a';

            if(node.children[idx] == null) {
                //add new node
                node.children[idx] = new TrieNode();
            }

            node = node.children[idx];
            if(i == word.length() - 1)
                node.eow = true;
        }
    }

    static String ans = "";

    // LONGEST WORD WITH ALL PREFIXES
    public String longestPrefixWord(TrieNode root, StringBuilder temp) {
       if(root == null){
           return "";
       }

       for(int i=0; i<26; i++) {
           if(root.children[i] != null && root.children[i].eow == true) {
               temp.append( (char)(i+'a'));

               if(temp.length() > ans.length()){
                   ans = temp.toString();
               }
               longestPrefixWord(root.children[i], temp);
               // WHEN BACKTRACKING REMOVE LAST CHARACTER IN TEMP FOR EACH RECURSIVE CALL
               temp.deleteCharAt(temp.length()-1);
           }
       }
       return ans;
    }


    public static void main(String args[]){
        String words[] = {"a", "banana", "app", "appl", "ap", "apply", "apple"};

        LongestWordWithAllPrefixes trie = new LongestWordWithAllPrefixes();

        System.out.println("the words are : ");
        for(String word : words)
            System.out.println(word);

        // insertion
        for(String word : words)
            trie.insert(word);

        // LONGEST WORD WITH ALL PREFIX IN THE TRIE
        System.out.println("\nLongest String that has all the prefixes in the Trie");
        System.out.println(trie.longestPrefixWord(trie.root, new StringBuilder()));

    }
}

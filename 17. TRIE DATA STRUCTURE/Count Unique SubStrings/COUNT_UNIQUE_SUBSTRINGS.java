/*

COUNT UNIQUE SUBSTRINGS
given a string of length n of lowercase alphabet characters,
we need to count total number of distinct substrings of this string

str = "ababa"
ans = 10

 */
import java.util.*;
public class COUNT_UNIQUE_SUBSTRINGS {
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


    // COUNT UNIQUE SUBSRINGS
    public static int countNodes(TrieNode root){
        if(root == null){
            return 0;
        }

       int count = 0;
        for(int i = 0; i < 26; i++){
            if(root.children[i] != null){
                count += countNodes(root.children[i]);
            }
        }
        return count + 1;
    }

    public static void main(String args[]){
        String str = "apple";

        COUNT_UNIQUE_SUBSTRINGS trie = new COUNT_UNIQUE_SUBSTRINGS();

        for(int i = 0; i < str.length(); i++){
            String suffix = str.substring(i);
            trie.insert(suffix);
        }

        System.out.println("Number od substrings of "+ str + " is = " + countNodes(trie.root));
    }
}


/*

📌 Example: str = "apple"

We insert all suffixes:

i=0 → "apple"
i=1 → "pple"
i=2 → "ple"
i=3 → "le"
i=4 → "e"

🔍 Trie Construction (Step by Step)
Insert "apple"

root → 'a' (new node)
'a' → 'p' (new node)
'p' → 'p' (new node)
'p' → 'l' (new node)
'l' → 'e' (new node)
✅ 5 new nodes created.

Insert "pple"
root → 'p' (new node)
'p' → 'p' (new node)
'p' → 'l' (new node)
'l' → 'e' (new node)
✅ 4 new nodes created.

Insert "ple"
root → 'p' (exists)
'p' → 'l' (new node)
'l' → 'e' (new node)
✅ 2 new nodes created.

Insert "le"
root → 'l' (new node)
'l' → 'e' (new node)

✅ 2 new nodes created.
Insert "e"

root → 'e' (new node)
✅ 1 new node created.

📊 Total Count of Nodes

"apple" → 5
"pple" → 4
"ple" → 2
"le" → 2
"e" → 1
Plus root = 1

👉 Total nodes = 15

 */
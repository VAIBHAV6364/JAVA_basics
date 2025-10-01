/*

STARTS WITH PROBLEM
create a function boolean startsWith(String prefix) for a trie.
returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.

words[] = {"apple", "app", "mango", "man", "woman"}
prefix = "app"      output :  true
prefix = "moon"     output :  false

 */

public class startsWithProblem {
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


    // STARTS WITH PROBLEM
    public boolean startsWith(String key){
        TrieNode node = root;
        for(int i = 0; i < key.length(); i++){
            int idx = key.charAt(i) - 'a';

            if(node.children[idx] == null)
                return false;

            node = node.children[idx];    // move down the trie
        }
        return true;
    }


    public static void main(String args[]){
        String words[] = {"apple", "app", "mango", "man", "woman"};

        startsWithProblem trie = new startsWithProblem();

        // insertion
        for(String word : words)
            trie.insert(word);

        String key = "app";
        System.out.println("Does any word start with prefix \"" + key + "\" ? " + (trie.startsWith(key) ? "YES" : "NO"));

        key = "moon";
        System.out.println("Does any word start with prefix \"" + key + "\" ? " + (trie.startsWith(key) ? "YES" : "NO"));

    }
}

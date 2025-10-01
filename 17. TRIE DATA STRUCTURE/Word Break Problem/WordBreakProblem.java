/*

WORD BREAK PROBLEM
Given an input string and a dictionary of words, find out if the input string can
be broken into a space separated sequence of dictionary words.

words[] = { i, like, sam, samsung, mobile, ice}
key = "ilikesamsung"

output : true

 */

public class WordBreakProblem {
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


    // SEARCH
    public boolean search(String key){
        TrieNode node = root;
        for(int i = 0; i < key.length(); i++){
            int idx = key.charAt(i) - 'a';

            node = node.children[idx];
            if(node == null)
                return false;

            if(i == key.length() - 1 && node.eow == false)
                return false;
        }
        return true;
    }


    // WORD BREAK PROBLEM
    public boolean wordBreakSearch(String key){
        if(key.length() == 0)
            return true;

        for(int i = 1; i <= key.length(); i++){
            String firstPart = key.substring(0,i);
            String secondPart = key.substring(i);
            if(search(firstPart) && wordBreakSearch(secondPart))
                return true;
        }
        return false;
    }


    public static void main(String args[]){
        String words[] = {"i","like","sam","samsung","mobile","ice"};

        WordBreakProblem trie = new WordBreakProblem();

        // insertion
        for(String word : words)
            trie.insert(word);

        String key = "ilikesamsung";

        System.out.println(" key : "+ key +" \n found in tree through word break? ----> " + trie.wordBreakSearch(key));
    }
}



/*

📚 Dictionary Inserted into Trie
["i", "like", "sam", "samsung", "mobile", "ice"]


Trie nodes are built so that:
"i" → marks eow = true
"like" → path l → i → k → e (eow = true at 'e')
"sam" → s → a → m (eow = true at 'm')
"samsung" → s → a → m → s → u → n → g (eow = true at 'g')
etc.

🔍 Trace of wordBreakSearch("ilikesamsung")
Call wordBreakSearch("ilikesamsung")
Loop i = 1 → firstPart = "i", secondPart = "likesamsung"
search("i") → true ✅ (found in dictionary)
Recurse → wordBreakSearch("likesamsung")

Call wordBreakSearch("likesamsung")
i = 1 → firstPart = "l", not found ❌
i = 2 → firstPart = "li", not found ❌
i = 3 → firstPart = "lik", not found ❌
i = 4 → firstPart = "like", found ✅
Recurse → wordBreakSearch("samsung")

Call wordBreakSearch("samsung")
i = 1 → firstPart = "s", not found ❌
i = 2 → firstPart = "sa", not found ❌
i = 3 → firstPart = "sam", found ✅
Recurse → wordBreakSearch("sung")
BUT "sung" is not in dictionary ❌, so recursion backtracks.
Next, i keeps going:
i = 7 → firstPart = "samsung", found ✅
Recurse → wordBreakSearch("")

Call wordBreakSearch("")
Base case → return true

✅ So final recursion unwinds:

"samsung" ✅

"like" ✅

"i" ✅

Hence "ilikesamsung" = true

 */
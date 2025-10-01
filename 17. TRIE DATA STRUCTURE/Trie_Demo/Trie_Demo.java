import java.util.*;
public class Trie_Demo {
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

    // PRINT ALL WORDS IN THE TRIE
    public void printAllWordsOfTrie(TrieNode node, StringBuilder sb){
        if(node.eow){
            System.out.println(sb.toString());
        }

        for(int i = 0; i < 26; i++){
            if(node.children[i] != null){
                sb.append((char)(i + 'a'));     // add character
                printAllWordsOfTrie(node.children[i], sb);
                sb.deleteCharAt(sb.length() - 1);     // BackTracking
            }
        }
    }

    // PRINT ALL WORDS IN REVERSE LEXICOGRAPHIC ORDER
    public void ReversePrinter(TrieNode root){
        List<String> wordsList = new ArrayList<>();
        collectWords(root, new StringBuilder(), wordsList);

        Collections.reverse(wordsList);
        System.out.println("All words (reversed): ");
        for(int i = 0; i < wordsList.size(); i++)
            System.out.println(wordsList.get(i));
    }

    public static void collectWords(TrieNode node, StringBuilder sb, List<String> result){
        if(node.eow){
            result.add(sb.toString());
        }

        for(int i = 0; i < 26; i++){
            if(node.children[i] != null){
                sb.append((char)(i + 'a'));
                collectWords(node.children[i], sb, result);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }



    public static void main(String args[]){
        String words[] = {"the", "a", "there", "their", "any"};

        Trie_Demo trie = new Trie_Demo();

        // insertion
        for(String word : words)
            trie.insert(word);

        // PRinting
        System.out.println("All words in the Trie in ascending order : ");
        trie.printAllWordsOfTrie(trie.root, new StringBuilder());
        System.out.println();

        // Reverse PRinting
        System.out.println("All words in the Trie in reverse alphabetical order : ");
        trie.ReversePrinter(trie.root);
        System.out.println();

        System.out.println("Search for their , found ? : "+ trie.search("their"));
        System.out.println("\n Search for three , found ? : "+ trie.search("three"));
    }
}

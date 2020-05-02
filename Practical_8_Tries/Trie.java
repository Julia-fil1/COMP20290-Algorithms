package lab8_trie;

//import Trie.TrieNode;

public class Trie {
    // Alphabet size (# of symbols) we pick 26 for English alphabet
    private static final int ALPHABET_SIZE = 26;

    // class for Trie node
    public static class TrieNode {
        final TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        // isEndOfWord is true if the node represents end of a word i.e. leaf node
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    }

    private static TrieNode root;


    // If not key present, inserts into trie
    // If the key is prefix of Trie node,
    // marks leaf node
    private static void insert(String key) {
        TrieNode trieNode = new TrieNode();
        TrieNode node = root;
        int index;
        for (int i = 0; i < key.length(); i++) {

            index = key.charAt(i) - 'a';

            if (trieNode.children[index] == null) {
                node.children[index] = new TrieNode();
                //letter = key.charAt(i);
            }
            node = node.children[index];

        }
        node.isEndOfWord = true;
    }

    // Returns true if key presents in trie, else false
    private static boolean search(String key) {
        TrieNode node = root;
        int index;
        for (int i = 0; i < key.length(); i++) {
            index = key.charAt(i) - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return (node != null && node.isEndOfWord);
    }

    // Driver
    public static void main(String[] args) {
//// Input keys (use only 'a' through 'z' and lower case)
//        String keys[] = {"bank", "book", "bar", "bring", "film", "filter", "simple", "silt",
//                "silver"};
//        String output[] = {"Not present in trie", "Present in trie"};
//        root = new TrieNode();
//// Construct trie
//        int i;
//        for (i = 0; i < keys.length ; i++) {
//            insert(keys[i]);
//        }
//// Search for different keys
        // Input keys (use only 'a' through 'z' and lower case)
        String[] keys = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};

        String[] output = {"Not present in trie", "Present in trie"};


        root = new TrieNode();

        // Construct trie
        int i;
        for (i = 0; i < keys.length; i++)
            insert(keys[i]);

        // Search for different keys
        if (search("the"))
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);

        if (search("these"))
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);

        if (search("their"))
            System.out.println("their --- " + output[1]);
        else System.out.println("their --- " + output[0]);

        if (search("thaw"))
            System.out.println("thaw --- " + output[1]);
        else System.out.println("thaw --- " + output[0]);

    }
}
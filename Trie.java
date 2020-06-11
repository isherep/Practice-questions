public class Trie {

    TrieNode root;

    public Trie(){
        TrieNode root = new TrieNode(' ');
    }

    public void insert(String word){
        TrieNode cur = root;
        // go over each character in the string inserting it into the trie level
        // start at first character of word, put itat the cur
        // level and
        for(int i = 0; i< word.length(); i++){
            char c = word.charAt(i);
            // check if current children have c - check pos in array
            // if they do -
            // if not - create a new TrieNode with the val c
            if(cur.children[c-'a'] == null){
                cur.children[c-'a'] = new TrieNode(c);
            }
            cur = cur.children[c-'a'];
        }
        // at the end of the loop the word will come to the end so mark
        // the last node as the end
        cur.isWord = true;
    }

    public boolean search(String word){
        TrieNode cur = root;

        for(int i = 0; i< word.length(); i++){
            char c = word.charAt(i);
            if(cur.children[c-'a'] == null){
                return false;
            } else {
                cur = cur.children[c -'a'];
            }
        }
        // if in the end you come to the word's end - word is found
        // if not the end - you just found a substring of larger word
        if(cur.isWord){
            return true;
        } else {
            return false;
        }
    }


    private class TrieNode{

        int ALPHABET_SIZE = 26;
        char val;
        TrieNode[] children;
        boolean isWord;

        public TrieNode(char c){
            isWord = false;
            children = new TrieNode[ALPHABET_SIZE];
            val = c;
        }
    }
}



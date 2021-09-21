package Tree;

/**
 * @author cqp
 * @version 1.0.0
 * @ClassName Trie.java
 * @Description TODO
 * @createTime 2021年09月21日 20:28:00
 */
public class Trie {

    public TrieNode root;

    class TrieNode {
        private boolean isEnd;
        TrieNode[] children;

        public TrieNode(){
            isEnd = false;
            children = new TrieNode[26];
        }
    }


    /** Initialize your data structure here. */
    public Trie() {
         root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()){
            if(node.children[c - 'a'] == null){
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()){
            node = node.children[c - 'a'];
            if(node == null){
                return false;
            }
        }
        return node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char c : prefix.toCharArray()){
            node = node.children[c - 'a'];
            if(node == null){
                return false;
            }
        }
        return false;
    }
}

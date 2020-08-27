package trie;

public class Trie {
    private TrieNode node;

    public Trie() {
        this.node = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        TrieNode iterator = node;

        for(int index = 0; index < chars.length; index ++) {
            if (!iterator.getElements().containsKey(chars[index])) {
                TrieNode newNode = new TrieNode(chars[index]);
                iterator.getElements().put(chars[index], newNode);
            }
            iterator = iterator.getElements().get(chars[index]);
            if(index == chars.length-1) {
                iterator.isCompleteWord(true);
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode iterator = node;
        for(char character: word.toCharArray()) {
            if(!iterator.getElements().containsKey(character)) {
                return false;
            }
            iterator = iterator.getElements().get(character);
        }

        return iterator.isCompleteWord();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode iterator = node;
        for(char character: prefix.toCharArray()) {
            if(!iterator.getElements().containsKey(character)) {
                return false;
            }
            iterator = iterator.getElements().get(character);
        }

        return true;
    }
}

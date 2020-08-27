package trie;

import java.util.HashMap;

public class TrieNode {
    private Character character;
    private Boolean isCompleteWord;
    private HashMap<Character, TrieNode> elements;

    public TrieNode() {
        this.elements = new HashMap<>();
    }

    public TrieNode(Character character) {
        this();
        this.character = character;
        this.isCompleteWord = false;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Boolean isCompleteWord() {
        return isCompleteWord;
    }

    public void isCompleteWord(Boolean isCompleteWord) {
        this.isCompleteWord = isCompleteWord;
    }

    public HashMap<Character, TrieNode> getElements() {
        return elements;
    }
}

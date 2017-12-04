package com.zenefits.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Trie {

    private TrieNode root;
    private boolean isEmpty = true;

    public Trie() {
        root = new TrieNode();
    }

    public void insert (String word) {
        TrieNode node = root;
        for (Character ch : word.toCharArray()) {
            if (node.getMap().get(ch) != null) {
                node = node.getMap().get(ch);
            } else {
                TrieNode temp = new TrieNode();
                node.getMap().put(ch, temp);
                node = temp;
            }
        }
        node.setEnd(true);
        this.isEmpty = false;
    }

    /*
    case 1: The partial word doesnt exist in the trie, return empty list
    case 2: The partial word exist but is the end of Trie, return the partial word
    case 3: The partial word is not the end of Trie, return possibilities;
     */
    public List<String> autoCompleteSearch(String partialWord) {
        List<String> list = new ArrayList<String>();
        TrieNode node = root;
        for (Character ch : partialWord.toCharArray()) {
            if (!node.getMap().containsKey(ch)) {
                return list;
            } else {
                node = node.getMap().get(ch);
            }
        }
        if (node.isEnd()) {
            list.add(partialWord);
            return list;
        } else {
            autoCompletePreOrderSearch(node, list, partialWord);
        }
        return list;
    }

    private void autoCompletePreOrderSearch(TrieNode node, List<String> list, String word) {
        if (node.isEnd()) {
            list.add(word);
        }
        for (Map.Entry<Character, TrieNode> entry : node.getMap().entrySet()) {
            autoCompletePreOrderSearch(entry.getValue(), list, word + entry.getKey());
        }
    }

    public boolean isEmpty() {
        return isEmpty;
    }
}

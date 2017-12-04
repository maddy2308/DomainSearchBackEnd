package com.zenefits.model;

import java.util.HashMap;
import java.util.Map;

class TrieNode {

    private Map<Character, TrieNode> map;
    private boolean isEnd;

    TrieNode() {
        this.map = new HashMap<Character, TrieNode>();
        isEnd = false;
    }

    Map<Character, TrieNode> getMap() {
        return map;
    }

    public void setMap(Map<Character, TrieNode> map) {
        this.map = map;
    }

    boolean isEnd() {
        return isEnd;
    }

    void setEnd(boolean end) {
        isEnd = end;
    }
}

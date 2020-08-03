package com.mycompany.fuhu.tree;
class TrieNode{
    private TrieNode[] links;
    static private final int R=26;
    private boolean isEnd;
    public TrieNode()
    {
        links = new TrieNode[R];
    }
    public boolean containsKey(char ch)
    {
        return links[ch - 'a'] != null;
    }
    public TrieNode get(char ch)
    {
        return links[ch -'a'];
    }
    public void put(char ch, TrieNode node)
    {
        links[ch -'a'] = node;
    }
    public void setEnd()
    {
        isEnd = true;
    }
    public boolean isEnd()
    {
        return isEnd;
    }
}

public class Trie {
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i =0; i< word.length();i++)
        {
            char cur = word.charAt(i);
            if(!node.containsKey(cur))
            {
                node.put(cur, new TrieNode());
            }
            node = node.get(cur);
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    private TrieNode searchPrefix(String prefix) {
        TrieNode node = root;
        for(int i =0; i< prefix.length();i++)
        {
            char cur = prefix.charAt(i);
            if (node.containsKey(cur))
            {
                node = node.get(cur);
            }
            else
            {
                return null;
            }
        }
        return node;
    }
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
    public static void main(String argv[])
    {
        Trie obj = new Trie();
        String word = "test";
        obj.insert(word);
        boolean param_2 = obj.search(word);
        boolean param_3 = obj.startsWith("tes");
        System.out.println("param_2: " + param_2 + ", param_3: " + param_3);
    }
}

package DataStructures.Trie;

public class TrieInsertSearch {

    static Integer MAX_ALPHABET = 26;

    static class TrieNode {

        TrieNode[] children;
        Boolean isLeafNode;

        TrieNode() {
            children = new TrieNode[MAX_ALPHABET];
            isLeafNode = false;
        }
    }

    TrieNode root;

     public void insert(String key) {
        TrieNode crawlNode = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (crawlNode.children[index] == null) {
                crawlNode.children[index] = new TrieNode();
            }
            crawlNode = crawlNode.children[index];
        }
        crawlNode.isLeafNode = true;
    }

    public Boolean search(String key) {
        TrieNode crawlNode = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (crawlNode.children[index] == null) {
                return Boolean.FALSE;
            }
            crawlNode = crawlNode.children[index];
        }

        return crawlNode.isLeafNode;
    }

    public static void main(String[] args) {
        TrieInsertSearch trieInsertSearch = new TrieInsertSearch();
        trieInsertSearch.root = new TrieNode();
        trieInsertSearch.insert("sravanapriyam");
        trieInsertSearch.insert("sravana");
        trieInsertSearch.insert("priyam");
        System.out.println(trieInsertSearch.search("sravanap"));
        System.out.println(trieInsertSearch.search("sravana"));
        System.out.println(trieInsertSearch.search("sravanapriya"));
        trieInsertSearch.insert("sravanapriya");
        System.out.println(trieInsertSearch.search("sravanapriya"));
    }
}

package DataStructures.Trie;

/**
 * User: Sravana Kumar K
 * Date: 09-11-2018 09:02 PM
 */
public class TrieInsertSearch {

    static Integer MAX_ALPHABET = 26;
    private TrieNode root;

    static class TrieNode {

        TrieNode[] children;
        Boolean isLeafNode;

        TrieNode() {
            children = new TrieNode[MAX_ALPHABET];
            isLeafNode = false;
        }
    };

    TrieInsertSearch() {
        root = new TrieNode();
    }

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

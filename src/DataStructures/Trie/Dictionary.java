package DataStructures.Trie;

/**
 * User: Sravana Kumar K
 * Date: 09-11-2018 09:02 PM
 */
public class Dictionary {

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

    Dictionary() {
        root = new TrieNode();
    }

    private Integer childCount(TrieNode node) {
        int childCount = 0;
        for (int i = 0; i < MAX_ALPHABET; i++) {
            if (node.children[i] != null) {
                childCount++;
            }
        }

        return childCount;
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

    public Boolean delete(String key) {
        if (!search(key)) {
            System.out.println("Invalid key");
            return Boolean.FALSE;
        }
        TrieNode crawlNode = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (1 == childCount(crawlNode.children[index]) && false == crawlNode.children[index].isLeafNode) {
                crawlNode.children[index] = null;
                return Boolean.TRUE;
            }
            crawlNode = crawlNode.children[index];
        }
        crawlNode.isLeafNode = false;
        return Boolean.TRUE;
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        String[] words = { "she", "sells", "sea", "shore", "the", "by", "sheer" };
        for (String word : words) {
            dictionary.insert(word);
        }

        System.out.println(dictionary.search("she"));
        System.out.println(dictionary.delete("she"));
        System.out.println(dictionary.search("sheer"));
        System.out.println(dictionary.search("she"));

        System.out.println(dictionary.search("by"));
        System.out.println(dictionary.delete("by"));
        System.out.println(dictionary.search("by"));

        System.out.println(dictionary.delete("th"));

        System.out.println(dictionary.search("sea"));
        System.out.println(dictionary.delete("sea"));
        System.out.println(dictionary.search("sea"));
        System.out.println(dictionary.search("sells"));
    }
}

package DataStructures.Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: Sravana Kumar K
 * Date: 09-11-2018 09:37 PM
 */
public class StringTokenizer {

    private List<String> getTokens(String word, TrieInsertSearch disctionary) {
        if (disctionary.search(word)) return new ArrayList<>(Arrays.asList(word));

        List<String> tokens = new ArrayList<>();
        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            if (disctionary.search(prefix)) {
                String suffix = word.substring(i);
                List<String> ret = getTokens(suffix, disctionary);
                if (ret != null) {
                    tokens.add(prefix);
                    tokens.addAll(ret);
                    return  tokens;
                }
            }
        }
        return null;
    }

    private Boolean ableToBreakOrNot(String word, TrieInsertSearch disctionary) {
        if (disctionary.search(word)) return Boolean.TRUE;

        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            if (disctionary.search(prefix)) {
                String suffix = word.substring(i);
                if (ableToBreakOrNot(suffix, disctionary)) {
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }

    private String getTokenizedString(String word, TrieInsertSearch disctionary) {
        if (disctionary.search(word)) return word;

        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            if (disctionary.search(prefix)) {
                String suffix = word.substring(i);
                String ret = getTokenizedString(suffix, disctionary);
                if (ret != null) {
                    return  prefix + " " + ret;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TrieInsertSearch disctionary = new TrieInsertSearch();
        String[] words = { "on", "pi", "pin", "pins", "sand", "and", "niddle", "niddles", "less"};
        for (String word : words) {
            disctionary.insert(word);
        }
        String sentence = "onpinsandniddles";
        StringTokenizer stringTokenizer = new StringTokenizer();

        System.out.println(stringTokenizer.ableToBreakOrNot(sentence, disctionary));
        System.out.println(stringTokenizer.getTokens(sentence, disctionary));
        System.out.println(stringTokenizer.getTokenizedString(sentence, disctionary));
    }
}

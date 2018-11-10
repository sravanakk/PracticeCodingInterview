package DataStructures.Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: Sravana Kumar K
 * Date: 09-11-2018 09:37 PM
 */
public class StringTokenizer {

    private List<String> getTokens(String word, Dictionary dictionary) {
        if (dictionary.search(word)) return new ArrayList<>(Arrays.asList(word));

        List<String> tokens = new ArrayList<>();
        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            if (dictionary.search(prefix)) {
                String suffix = word.substring(i);
                List<String> ret = getTokens(suffix, dictionary);
                if (ret != null) {
                    tokens.add(prefix);
                    tokens.addAll(ret);
                    return  tokens;
                }
            }
        }
        return null;
    }

    private Boolean ableToBreakOrNot(String word, Dictionary dictionary) {
        if (dictionary.search(word)) return Boolean.TRUE;

        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            if (dictionary.search(prefix)) {
                String suffix = word.substring(i);
                if (ableToBreakOrNot(suffix, dictionary)) {
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }

    private String getTokenizedString(String word, Dictionary dictionary) {
        if (dictionary.search(word)) return word;

        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            if (dictionary.search(prefix)) {
                String suffix = word.substring(i);
                String ret = getTokenizedString(suffix, dictionary);
                if (ret != null) {
                    return  prefix + " " + ret;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        String[] words = { "on", "pi", "pin", "pins", "sand", "and", "niddle", "niddles", "less"};
        for (String word : words) {
            dictionary.insert(word);
        }
        String sentence = "onpinsandniddles";
        StringTokenizer stringTokenizer = new StringTokenizer();

        System.out.println(stringTokenizer.ableToBreakOrNot(sentence, dictionary));
        System.out.println(stringTokenizer.getTokens(sentence, dictionary));
        System.out.println(stringTokenizer.getTokenizedString(sentence, dictionary));
    }
}

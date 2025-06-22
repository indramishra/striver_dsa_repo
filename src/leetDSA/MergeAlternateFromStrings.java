package leetDSA;

import java.util.Map;

public class MergeAlternateFromStrings {

    public static void main(String[] args) {
        String w1 = "abc";
        String w2 = "pqrs";
        System.out.println(mergeAlternately(w1, w2));
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int maxSize = Math.max(word1.length(), word2.length());
        for(int i = 0; i < maxSize ; i++) {
            if(i < word1.length()) {
                result.append(word1.charAt(i));
            }
            if(i < word2.length()) {
                result.append(word2.charAt(i));
            }
        }
        Map<String, Integer> map = Map.of("Alice", 25, "Bob", 30);
        System.out.println(map);
        return result.toString();
    }
}

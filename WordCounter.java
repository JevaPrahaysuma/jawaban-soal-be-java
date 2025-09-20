import java.util.*;

public class WordCounter {
    public static void countWords(String text) {
        String[] words = text.toLowerCase().split("\\W+");
        
        Map<String, Integer> wordCount = new LinkedHashMap<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        String input = "This is a test. This is only a test";
        countWords(input);
    }
}

package week2.assignment_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StopWordFilteredWordFrequencyReport {

    /**
     * Prints filtered word frequencies sorted by count in descending order.
     *
     * @param feedback The paragraph of feedback text.
     */
    public static void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.isEmpty()) return;

        // The list of stop words
        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};

        // Normalize text
        String cleanedText = feedback.toLowerCase();
        cleanedText = cleanedText.replace(".", "");
        cleanedText = cleanedText.replace(",", "");

        String[] words = cleanedText.split("\\s+");
        Map<String, Integer> wordCounts = new HashMap<>();

        for (String word : words) {
            if (word.isEmpty()) continue;

            boolean isStopWord = false;
            for (String stopWord : stopWords) {
                if (word.equals(stopWord)) {
                    isStopWord = true;
                    break;
                }
            }

            if (!isStopWord) {
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        }

        // Sort by count in descending order
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(wordCounts.entrySet());
        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

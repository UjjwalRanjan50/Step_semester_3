package week2.assignment_problems;

public class WordReversalEncoder {

    /**
     * Reverses every word in a sentence individually while keeping the word order the same.
     *
     * @param sentence The sentence to encode.
     * @return The encoded sentence with reversed words.
     */
    public static String reverseEachWord(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return sentence;
        }

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder reversedWord = new StringBuilder(words[i]);
            reversedWord.reverse();
            result.append(reversedWord);

            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}

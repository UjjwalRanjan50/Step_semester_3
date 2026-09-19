package week1.assignment_problems;

public class MovieReviewWordLengthProfiler {

    /**
     * Profiles word lengths in a movie review string.
     *
     * @param review the movie review text
     */
    public static void classifyWordLengths(String review) {
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        String[] words = review.split("\\s+");
        
        int shortWords = 0;
        int mediumWords = 0;
        int longWords = 0;
        
        for (String word : words) {
            // strip out non-letters if needed, but based on example we can just use length
            // though standard split by whitespace might include punctuation. 
            // For logic-building purposes, a simple length check is sufficient.
            int len = word.length();
            if (len >= 1 && len <= 4) {
                shortWords++;
            } else if (len >= 5 && len <= 8) {
                mediumWords++;
            } else if (len >= 9) {
                longWords++;
            }
        }
        
        System.out.println("Short: " + shortWords + " | Medium: " + mediumWords + " | Long: " + longWords);
    }
}

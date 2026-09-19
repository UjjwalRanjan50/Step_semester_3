package week1.assignment_problems;

public class TypingSpeedTestAccuracyChecker {

    /**
     * Checks typing accuracy by comparing original text to user's typed text.
     *
     * @param original the original passage
     * @param typed    the user's typed passage
     */
    public static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null || original.length() != typed.length()) {
            System.out.println("Strings must be non-null and of equal length.");
            return;
        }

        int matchedCount = 0;
        int firstMismatchPosition = -1;
        
        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matchedCount++;
            } else if (firstMismatchPosition == -1) {
                firstMismatchPosition = i + 1; // using 1-based index as per example position 11 for "hello worlt"
            }
        }
        
        double accuracy = ((double) matchedCount / original.length()) * 100.0;
        
        if (firstMismatchPosition == -1) {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches\n", 
                              matchedCount, original.length(), accuracy);
        } else {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')\n",
                              matchedCount, original.length(), accuracy, firstMismatchPosition, 
                              original.charAt(firstMismatchPosition - 1), typed.charAt(firstMismatchPosition - 1));
        }
    }
}

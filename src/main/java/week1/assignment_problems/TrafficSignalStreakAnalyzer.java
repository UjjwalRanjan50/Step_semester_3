package week1.assignment_problems;

public class TrafficSignalStreakAnalyzer {

    /**
     * Finds and prints the longest continuous streak of the same color in the log.
     *
     * @param signalLog string representing a sequence of signal readings
     */
    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.length() == 0) {
            System.out.println("Log is empty.");
            return;
        }

        int maxStreak = 0;
        char maxChar = ' ';
        
        int currentStreak = 1;
        char currentChar = signalLog.charAt(0);
        
        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentChar) {
                currentStreak++;
            } else {
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                    maxChar = currentChar;
                }
                currentChar = signalLog.charAt(i);
                currentStreak = 1;
            }
        }
        
        // Final check for the last sequence
        if (currentStreak > maxStreak) {
            maxStreak = currentStreak;
            maxChar = currentChar;
        }
        
        System.out.println("Longest Streak: '" + maxChar + "' repeated " + maxStreak + " times");
    }
}

package fantasy_league.assignment_problems;

public class MatchDayGridAnalyzer {

    /**
     * Helper method to compute the average of a row (match).
     */
    private static double rowAverage(int[] row) {
        if (row == null || row.length == 0) return 0.0;
        int sum = 0;
        for (int runs : row) {
            sum += runs;
        }
        return (double) sum / row.length;
    }

    /**
     * Flags matches as "Power Surge" or "Normal" based on average runs per over.
     */
    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        if (runsPerOver == null || runsPerOver.length == 0) return "";
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            
            if (i > 0) {
                result.append(" | ");
            }
            
            result.append("Match ").append(i).append(": ");
            if (avg >= threshold) {
                result.append("Power Surge");
            } else {
                result.append("Normal");
            }
        }
        
        return result.toString();
    }
}

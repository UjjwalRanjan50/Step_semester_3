package fantasy_league.assignment_problems;

public class TopPerformerTracker {

    /**
     * Finds the minimum, maximum, and spread of scores in a single pass.
     *
     * @param scores The array of scores.
     * @return String detailing min, max, and their spread.
     */
    public static String findMinMaxSpread(int[] scores) {
        if (scores == null || scores.length == 0) {
            return "No scores provided";
        }
        
        int min = scores[0];
        int max = scores[0];
        
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            } else if (scores[i] > max) { // using else if is slightly more efficient, though both checks are fine
                max = scores[i];
            }
        }
        
        return "Min: " + min + " | Max: " + max + " | Spread: " + (max - min);
    }
}

package session10.assignment_problems;

/**
 * Problem 7: Second-Best Score
 * 
 * Complexity Comparison:
 * - Sorting Approach:
 *   - Time Complexity: O(n log n).
 *   - Space Complexity: O(n) or O(log n) depending on whether original array can be modified.
 * - Single-Pass Approach (Current Solution):
 *   - Time Complexity: O(n), visiting each element exactly once.
 *   - Space Complexity: O(1) auxiliary space, requiring only two tracking variables.
 */
public class SecondBestScore {

    /**
     * Finds the second-highest distinct score in an array without sorting.
     *
     * @param scores array of player scores
     * @return the second-highest distinct score, or -1 if no second distinct score exists
     */
    public static int secondHighest(int[] scores) {
        if (scores == null || scores.length < 2) {
            return -1;
        }

        int highest = -1;
        int second = -1;

        for (int score : scores) {
            if (score > highest) {
                second = highest;
                highest = score;
            } else if (score < highest && score > second) {
                second = score;
            }
        }

        return second;
    }

    public static void main(String[] args) {
        int[] scores1 = {45, 78, 92, 78, 60};
        System.out.println(secondHighest(scores1)); // Expected: 78

        int[] scores2 = {50, 50, 50};
        System.out.println(secondHighest(scores2)); // Expected: -1
    }
}
